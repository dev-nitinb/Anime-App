package com.example.animeapp.ui.activity

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.animeapp.data.model.Anime
import com.example.animeapp.databinding.ActivityAnimeDetailBinding

class AnimeDetailActivity : AppCompatActivity() {

    lateinit var anime: Anime

    private lateinit var binding: ActivityAnimeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        anime = (intent.getSerializableExtra("anime") as Anime?)!!

        binding.anime = anime

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.webViewClient = WebViewClient()
        binding.webview.webChromeClient = WebChromeClient()
        binding.webview.loadUrl(anime.trailer.url)

        val genreNames= anime.genres.joinToString(", ") { it.name }
        binding.tvGenre.text = genreNames
    }
}