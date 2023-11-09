package com.example.my.pixabayapi.retrofitservice

import com.example.my.pixabayapi.model.PixabayModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    //https://pixabay.com/api/?key=25007027-7418deb977c638792f4bfb99f&q=car

    @GET("/api/")
    fun getImages(
        @Query("q")
        keyWord:String,
        @Query("page")
        page:Int = 1,
        @Query("per_page")
        perPage:Int = 5,
        @Query("key")
        key:String = "25007027-7418deb977c638792f4bfb99f"
    ): Call<PixabayModel>

}