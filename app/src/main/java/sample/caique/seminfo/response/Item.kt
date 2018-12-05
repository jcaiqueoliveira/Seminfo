package sample.caique.seminfo.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: Int,
    val description: String,
    val url: String,
    val score: Double,
    val owner: Owner,
    @SerialName("full_name") val name: String,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("watchers_count") val watcher: Int,
    @SerialName("stargazers_count") val stars: Int,
    @SerialName("forks_count") val forks: Int
)
