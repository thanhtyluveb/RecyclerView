package com.example.recyclerview

import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.recyclerview.model.ApiGitHub
import com.example.recyclerview.remote.retrofit.ApiUtils
import com.example.recyclerview.remote.retrofit.SOService

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var mService: SOService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mService = ApiUtils.soService




        loadata()
    }

    private fun loadata() {
        mService!!.EXAMPLE_CALL().enqueue(object : Callback<List<ApiGitHub>> {
            override fun onResponse(call: Call<List<ApiGitHub>>, response: Response<List<ApiGitHub>>) {
                val apiGitHubs = ArrayList<ApiGitHub>()
                for (i in 0 until response.body()!!.size) {
                    apiGitHubs.add(response.body()!![i])

                }
                val recyclerView = findViewById<RecyclerView>(R.id.rv)
                val adapter = Adapter(this@MainActivity, apiGitHubs)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<List<ApiGitHub>>, t: Throwable) {

            }
        })
    }


}
