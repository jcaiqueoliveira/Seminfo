package sample.caique.seminfo.response

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Issues(
    val title: String,
    val comments: Int,
    @Optional val body: String? = null
)
