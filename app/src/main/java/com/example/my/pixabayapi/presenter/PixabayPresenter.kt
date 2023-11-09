package com.example.my.pixabayapi.presenter

import android.util.Log
import com.example.my.pixabayapi.model.PixabayModel
import com.example.my.pixabayapi.retrofitservice.PixabayApiClient
import com.example.my.pixabayapi.view.PixabayView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PixabayPresenter(private var view: PixabayView) {

    private val pixabayApi = PixabayApiClient.create()

    fun searchImages(query: String) {
        pixabayApi.getImages(query).enqueue(object : Callback<PixabayModel> {
            override fun onResponse(call: Call<PixabayModel>, response: Response<PixabayModel>) {
                if (response.isSuccessful) {
                    Log.e("Tash", "onResponse: ${response.body()!!.hits}")
                    view.showImages(response.body()!!.hits)
                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                Log.e("Tash", t.message.toString())
            }
        })
    }

    fun attachView(view: PixabayView) {
        this.view = view
    }

}