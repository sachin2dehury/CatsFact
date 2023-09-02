package github.sachin2dehury.catsfact.singlefact

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    val active: Boolean? = null,
    val label: String? = null,
    val url: String? = null,
)
