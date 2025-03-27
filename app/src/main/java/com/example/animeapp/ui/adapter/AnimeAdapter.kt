package com.example.animeapp.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapp.data.model.Anime
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.ui.activity.AnimeDetailActivity

class AnimeAdapter(private val alAnimeList: ArrayList<Anime>) :
    RecyclerView.Adapter<AnimeAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun getItemCount(): Int {
        return alAnimeList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(alAnimeList[position])
    }

    inner class MovieViewHolder(private val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bindData(anime: Anime ) {
            binding.anime = anime
            Glide.with(context)
                .load(anime.images.jpg.image_url)
                .into(binding.ivPoster)
            binding.cardView.setOnClickListener {
                val intent = Intent(context, AnimeDetailActivity::class.java)
                intent.putExtra("anime", anime)
                context.startActivity(intent)
            }
        }
    }

}