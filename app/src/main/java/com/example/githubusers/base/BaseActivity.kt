package com.example.githubusers.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.githubusers.dagger.AppComponent
import com.example.githubusers.dagger.AppModule
import com.example.githubusers.network.GithubApi
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

open class BaseActivity(@LayoutRes private val layout: Int) : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(isLoading: Boolean) {
        when (isLoading) {
            true -> progress_bar.visibility = View.VISIBLE
            false -> progress_bar.visibility = View.GONE
        }
    }

}