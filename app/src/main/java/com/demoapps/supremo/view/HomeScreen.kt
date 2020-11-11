package com.demoapps.supremo.view

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoapps.supremo.R
import com.demoapps.supremo.interfaces.FlowCallBack
import com.demoapps.supremo.model.MainResponse
import com.demoapps.supremo.utils.ApplicationConstants
import com.demoapps.supremo.utils.CommonUtils
import com.demoapps.supremo.utils.Router
import com.demoapps.supremo.viewmodel.HomeScreenViewModel
import kotlinx.android.synthetic.main.activity_homescreen.*

/*
*This class is the landing page of the application
*/

class HomeScreen : ActivityBase(), FlowCallBack {
    private var homeScreenViewModel: HomeScreenViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_homescreen)
        init()
        bindView()
    }

    private fun init() {
        homeScreenViewModel = HomeScreenViewModel(this)
        initRecentSearch()
        val linearLayoutManager = LinearLayoutManager(this)
        rvRecentSearch.layoutManager = linearLayoutManager
    }

    private fun initRecentSearch() {
        //GET DATA FROM SHARED PREF FOR RECENT SEARCH
    }

    private fun bindView() {
        searchButton.setOnClickListener {
            if (TextUtils.isEmpty(etSearchText.text)) {
                CommonUtils.showAlertDialog(this, getString(R.string.search_box_error), false)
            } else {
                Router.searchSuperHeroName = etSearchText.text.toString()
                fetchResult()
            }
        }
    }

    private fun fetchResult() {
        progressBarLayout.visibility = View.VISIBLE
        rvRecentSearch.visibility = View.GONE
        homeScreenViewModel?.fireApi()
    }

    override fun onApiCalled() {}

    override fun onApiSuccess(mainResponse: MainResponse) {
        progressBarLayout.visibility = View.GONE
        rvRecentSearch.visibility = View.VISIBLE
        if (mainResponse.response.equals(ApplicationConstants.TXN_ERROR)) {
            CommonUtils.showAlertDialog(this, mainResponse.errorMessage, false)
        } else {
            //PUT DATA TO SHARED PREF FOR RECENT SEARCH
            Router.startSuperHeroDisplayFlow()
        }
    }

    override fun onApiFailed(error: Throwable) {
        progressBarLayout.visibility = View.GONE
        rvRecentSearch.visibility = View.VISIBLE
        CommonUtils.showAlertDialog(this, getString(R.string.something_went_wrong), false)
    }
}