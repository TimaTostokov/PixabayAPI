package com.example.my.pixabayapi.model

data class PixabayModel(
    var hits: ArrayList<ImageModel>
)

data class ImageModel(
    var largeImageUrl: String
)
