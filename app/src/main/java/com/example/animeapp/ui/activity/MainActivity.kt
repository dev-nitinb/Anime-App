package com.example.animeapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeapp.data.model.Anime
import com.example.animeapp.data.model.AnimeResponse
import com.example.animeapp.data.network.RetrofitClient
import com.example.animeapp.databinding.ActivityMainBinding
import com.example.animeapp.ui.adapter.AnimeAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var animeList = ArrayList<Anime>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAnimeList()
    }

    private fun getAnimeList() {
        showProgressBar()
        lifecycleScope.launch(Dispatchers.IO){
            try {
                val animeResponse = RetrofitClient.getApiService().getAnimeList()
                withContext(Dispatchers.Main) {
                    hideProgressBar()
                    animeResponse.data.let {
                        animeList.addAll(it.toList())
                    }
                    binding.rvAnime.layoutManager = LinearLayoutManager(applicationContext)
                    val movieAdapter = AnimeAdapter(animeList)
                    binding.rvAnime.adapter = movieAdapter
                }
            } catch (e: Exception) {
                Log.e(TAG, "Request failed: ${e.message}")
                withContext(Dispatchers.Main) {
                    hideProgressBar()
                }
            }
        }
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    companion object {
        const val TAG = "MainActivity"
    }

}