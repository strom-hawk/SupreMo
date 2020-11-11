package com.demoapps.supremo.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.demoapps.supremo.model.SuperHeroData
import com.demoapps.supremo.view.SuperHeroLandingActivity

object Router {
    var searchSuperHeroName = ""
    var superHerosList = ArrayList<SuperHeroData>()
    var selectedSuperHeroNumber = 0
}