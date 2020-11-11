package com.demoapps.supremo.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.demoapps.supremo.R
import com.demoapps.supremo.utils.ApplicationConstants
import com.demoapps.supremo.utils.Router
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_super_hero_details.*

class SuperHeroDetailsActivity: ActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar(Router.superHerosList.get(Router.selectedSuperHeroNumber).name)
        setContentView(R.layout.activity_super_hero_details)
        init()
    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return super.onSupportNavigateUp()
    }

    private fun init(){
        superHeroName.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).name
        superHeroDescription.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).groupAffiliation
        superHeroRaceValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).race
        superHeroGenderValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).gender
        superHeroHeightValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).height
        superHeroEyeColorValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).eyeColor
        superHeroHairColorValue.text = Router.superHerosList.get(Router.selectedSuperHeroNumber).hairColor


        Picasso.get().load(Router.superHerosList.get(Router.selectedSuperHeroNumber).imageUrl).into(superHeroImageView)
    }
}