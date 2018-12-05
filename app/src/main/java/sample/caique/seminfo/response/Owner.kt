package sample.caique.seminfo.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Owner(
    @SerialName("avatar_url") val imgUrl: String
)
