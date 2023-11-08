package com.example.my.pixabayapi.view

import com.example.my.pixabayapi.model.ImageModel

interface PixabayView {
    fun showImages(images: ArrayList<ImageModel>)
    fun showError(error: String)
}