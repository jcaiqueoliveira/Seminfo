package sample.caique.seminfo.domain

data class RepositoryOverview(
    val id: Int,
    val name: String,
    val url: String,
    val apiUrl: String,
    val description: String,
    val starCount: Int,
    val watcherCount: Int,
    val forkCount: Int,
    val imgUrl: String
)