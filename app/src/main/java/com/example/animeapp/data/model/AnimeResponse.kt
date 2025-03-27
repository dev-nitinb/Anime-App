package com.example.animeapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonObject
import java.io.Serializable

data class AnimeResponse(
    val pagination: Pagination,
    val data: List<Anime>
): Serializable


data class Pagination(
    @SerialName("last_visible_page") val lastVisiblePage: Int,
    @SerialName("has_next_page") val hasNextPage: Boolean,
    @SerialName("current_page") val currentPage: Int,
    val items: Items
) : Serializable


data class Items(
    val count: Int,
    val total: Int,
    @SerialName("per_page") val perPage: Int
)

data class Anime(
    @SerialName("mal_id") val malId: Int,
    val url: String,
    val images: Images,
    val trailer: Trailer,
    val approved: Boolean,
    val titles: List<Title>,
    val title: String,
    @SerialName("title_english") val titleEnglish: String,
    @SerialName("title_japanese") val titleJapanese: String,
    @SerialName("title_synonyms") val titleSynonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Int,
    val status: String,
    val airing: Boolean,
    val aired: Aired,
    val duration: String,
    val rating: String,
    val score: Double,
    @SerialName("scored_by") val scoredBy: Int,
    val rank: Int,
    val popularity: Int,
    val members: Int,
    val favorites: Int,
    val synopsis: String,
    val background: String,
    val season: String,
    val year: Int,
    val broadcast: Broadcast,
    val producers: List<Producer>,
    val licensors: List<Licensor>,
    val studios: List<Studio>,
    val genres: List<Genre>,
    val explicitGenres: List<String>,
    val themes: List<Any>,
    val demographics: List<Demographic>
): Serializable


data class Images(
    val jpg: ImageUrls,
    val webp: ImageUrls
): Serializable


data class ImageUrls(
    val image_url: String,
     val small_image_url: String,
    val large_image_url: String
): Serializable

data class Trailer(
    @SerialName("youtube_id") val youtubeId: String,
    val url: String,
    @SerialName("embed_url") val embedUrl: String,
    val images: TrailerImages
): Serializable

data class TrailerImages(
    @SerialName("image_url") val imageUrl: String,
    @SerialName("small_image_url") val smallImageUrl: String,
    @SerialName("medium_image_url") val mediumImageUrl: String,
    @SerialName("large_image_url") val largeImageUrl: String,
    @SerialName("maximum_image_url") val maximumImageUrl: String
): Serializable

data class Title(
    val type: String,
    val title: String
): Serializable

data class Aired(
    val from: String,
    val to: String,
    val prop: DateRange,
    val string: String
): Serializable

data class Date(
    val day: Int,
    val month: Int,
    val year: Int
): Serializable

data class DateRange(
    val from: Date,
    val to: Date
): Serializable

data class Broadcast(
    val day: String,
    val time: String,
    val timezone: String,
    val string: String
): Serializable

data class Producer(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
): Serializable

data class Licensor(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
): Serializable

data class Studio(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
): Serializable

data class Genre(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
): Serializable

data class Demographic(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
): Serializable
