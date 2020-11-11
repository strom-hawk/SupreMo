package com.demoapps.supremo.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoapps.supremo.R
import com.demoapps.supremo.adapter.ResultAdapter
import com.demoapps.supremo.interfaces.SuperHerosCallBack
import com.demoapps.supremo.utils.Router
import kotlinx.android.synthetic.main.activity_super_hero_landing.*

class SuperHeroLandingActivity : ActivityBase(), SuperHerosCallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_super_hero_landing)
        init()
    }

    private fun init() {
        val linearLayoutManager = LinearLayoutManager(this)
        rvSuperHeros.layoutManager = linearLayoutManager
        rvSuperHeros.adapter = ResultAdapter(this, Router.superHerosList, this)
        rvSuperHeros.adapter?.notifyDataSetChanged()

    }

    override fun onItemClickListener(itemNumber: Int) {
        Router.selectedSuperHeroNumber = itemNumber
        val intent = Intent(this, SuperHeroDetailsActivity::class.java)
        startActivity(intent)
    }
}