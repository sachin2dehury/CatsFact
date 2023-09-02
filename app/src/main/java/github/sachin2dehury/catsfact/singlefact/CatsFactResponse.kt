package github.sachin2dehury.catsfact.singlefact

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatsFactResponse(
    val fact: String? = null,
    val length: Int? = null,
)
