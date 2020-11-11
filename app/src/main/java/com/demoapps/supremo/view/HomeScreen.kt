package com.demoapps.supremo.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoapps.supremo.R
import com.demoapps.supremo.adapter.RecentSearchAdapter
import com.demoapps.supremo.interfaces.FlowCallBack
import com.demoapps.supremo.interfaces.RecentSearchCallBack
import com.demoapps.supremo.model.MainResponse
import com.demoapps.supremo.model.SuperHeroData
import com.demoapps.supremo.utils.ApplicationConstants
import com.demoapps.supremo.utils.CommonUtils
import com.demoapps.supremo.utils.Router
import com.demoapps.supremo.viewmodel.HomeScreenViewModel
import kotlinx.android.synthetic.main.activity_homescreen.*

/*
*This class is the landing page of the application
*/

class HomeScreen : ActivityBase(), FlowCallBack, RecentSearchCallBack {
    private var homeScreenViewModel: HomeScreenViewModel? = null
    private val recentSearch = ArrayList<String>()
    private var recentSearchSet:Set<String>? = null
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_homescreen)
        init()
        bindView()
    }

    private fun init() {
        homeScreenViewModel = HomeScreenViewModel(this)
        initSharedPref()
        initRecentSearch()
    }

    private fun initSharedPref(){
        sharedPreferences = this.getSharedPreferences(ApplicationConstants.RECENT_SEARCHES_SHARED_PREF_FILE, Context.MODE_PRIVATE)
    }

    private fun initRecentSearch() {
        recentSearchSet = sharedPreferences?.getStringSet(ApplicationConstants.RECENT_SEARCHES_KEY, null)
        recentSearchSet?.forEach {
            recentSearch.add(it)
        }

        if(recentSearch.isEmpty()){
            noItemsError.visibility = View.VISIBLE
            rvRecentSearch.visibility = View.GONE
        }else{
            noItemsError.visibility = View.GONE
            rvRecentSearch.visibility = View.VISIBLE
            val linearLayoutManager = LinearLayoutManager(this)
            rvRecentSearch.layoutManager = linearLayoutManager
            rvRecentSearch.adapter = RecentSearchAdapter(this, recentSearch, this)
            rvRecentSearch.adapter?.notifyDataSetChanged()
        }
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
            putSuccessFullSearchToSharedPref()
            rvRecentSearch.adapter?.notifyDataSetChanged()
            putReceivedResultInRouter(mainResponse)

            val intent = Intent(this, SuperHeroLandingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun putSuccessFullSearchToSharedPref(){
        val sharedPreferencesEditor = sharedPreferences?.edit()
        val updatedRecentSearch= HashSet<String>()
        recentSearch.add(Router.searchSuperHeroName)
        updatedRecentSearch.addAll(recentSearch)

        sharedPreferencesEditor?.putStringSet(ApplicationConstants.RECENT_SEARCHES_KEY, updatedRecentSearch)
        sharedPreferencesEditor?.apply()
    }

    private fun putReceivedResultInRouter(mainResponse: MainResponse){
        for((index, item) in mainResponse.results.withIndex()){
            val superHeroDetails = SuperHeroData()
            superHeroDetails.name = item.superHeroName
            superHeroDetails.groupAffiliation = item.connections.groupAffiliation
            superHeroDetails.imageUrl = item.superHeroImage.url

            Router.superHerosList.add(superHeroDetails)
        }
    }

    override fun onApiFailed(error: Throwable) {
        progressBarLayout.visibility = View.GONE
        rvRecentSearch.visibility = View.VISIBLE
        CommonUtils.showAlertDialog(this, getString(R.string.something_went_wrong), false)
    }

    override fun onItemClickListener(itemName: String) {
        Router.searchSuperHeroName = itemName
        fetchResult()
    }
}