package com.example.my.pixabayapi.model

import com.google.gson.annotations.SerializedName

data class PixabayModel(
    var hits: ArrayList<ImageModel>
)

data class ImageModel(
    @SerializedName("webformatURL")
    var webFormatUrl: String
)
