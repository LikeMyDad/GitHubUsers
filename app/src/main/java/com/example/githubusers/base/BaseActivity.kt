package com.example.githubusers.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity(@LayoutRes private val layout: Int) : AppCompatActivity(), BaseView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(isLoading: Boolean) {
         //todo
    }
}