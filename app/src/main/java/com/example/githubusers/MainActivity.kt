package com.example.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var listAdapterListUsers: RecyclerAdapterListUsers
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var service: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        /*
        * Создание сервиса ретрофит
        * Задаем в параметре класс с get запросом к серверу
         */
        service = NetworkService().createService(GithubApi::class.java)

        getListUsers()
    }

    private fun getListUsers() {
        val call: Call<MutableList<User>> = service.usersList()

        progress_bar.visibility = View.VISIBLE // Полоска прогресса, убирается при загрузке контента

        // Вызывается асинхронный колл для списка юзеров
        call.enqueue(object: Callback<MutableList<User>> {

            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                if(response.isSuccessful) {
                    listAdapterListUsers = RecyclerAdapterListUsers(response.body()!!) // адаптеру передается респонс в виде объектов в список
                    recyclerView.adapter = listAdapterListUsers // пробрасываем адаптер в ресайкл вью
                    progress_bar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT)
                progress_bar.visibility = View.GONE
            }
        })

    }


}