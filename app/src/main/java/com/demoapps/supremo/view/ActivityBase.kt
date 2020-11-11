package com.demoapps.supremo.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.demoapps.supremo.utils.ApplicationConstants
import io.reactivex.disposables.CompositeDisposable

abstract class ActivityBase: AppCompatActivity() {
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }

    fun setToolbar(title: String){
        this.supportActionBar?.show()
        val colorDrawable = ColorDrawable(Color.parseColor(ApplicationConstants.TOOL_BAR_COLOR))
        this.supportActionBar?.setBackgroundDrawable(colorDrawable)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setTitle(title)
    }

    fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}