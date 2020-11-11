package com.demoapps.supremo.view

import android.os.Bundle
import com.demoapps.supremo.R
import com.demoapps.supremo.utils.Router
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_super_hero_details.*

class SuperHeroDetailsActivity: ActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_super_hero_details)
        init()
    }

    private fun init(){
        superHeroName.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).name
        superHeroDescription.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).groupAffiliation
        superHeroRaceValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).race
        superHeroGenderValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).gender
        superHeroHeightValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).height
        Picasso.get().load(Router.superHerosList.get(Router.selectedSuperHeroNumber).imageUrl).into(superHeroImageView)
    }
}