package com.example.my.pixabayapi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my.pixabayapi.databinding.ActivityMainBinding
import com.example.my.pixabayapi.model.ImageModel
import com.example.my.pixabayapi.presenter.PixabayPresenter
import com.example.my.pixabayapi.ui.adapter.ImageAdapter
import com.example.my.pixabayapi.view.PixabayView

class MainActivity : AppCompatActivity(), PixabayView {

    private lateinit var binding: ActivityMainBinding


    private val presenter = PixabayPresenter(this)
    private val imageAdapter = ImageAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            presenter.searchImages(query)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun showImages(images: ArrayList<ImageModel>) {
        imageAdapter.addImage(images)
        val rv = binding.imageRecyclerView
        val layoutManager = LinearLayoutManager(this)
        rv.layoutManager = layoutManager
        rv.adapter = imageAdapter
        imageAdapter.cleanImage()
        imageAdapter.addImage(images)
        imageAdapter.notifyDataSetChanged()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
