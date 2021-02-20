package com.example.githubusers.model

import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.NetworkService
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import com.example.githubusers.base.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result.response
import java.util.function.Consumer

class Model : BaseModel {

    private val service = NetworkService()
        .createService(GithubApi::class.java)
    private val compositeDisposable = CompositeDisposable()

    override fun loadUserList(
        onSuccess: (List<User>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        compositeDisposable.add(service.usersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response: List<User> -> onSuccess(response)},
                {t: Throwable -> onError(t)}))
    }

    override fun loadUserListRepos(
        login: String,
        onSuccess: (List<Repos>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        compositeDisposable.add(service.reposList(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response: List<Repos> -> onSuccess(response)},
                {t: Throwable -> onError(t)}))
    }

}