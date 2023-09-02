package github.sachin2dehury.catsfact.paginated

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse
import github.sachin2dehury.catsfact.singlefact.Link

@JsonClass(generateAdapter = true)
data class CatFactsPaginatedResponse(
    @Json(name = "current_page")
    val currentPage: Int? = null,
    val data: List<CatsFactResponse?>? = null,
    @Json(name = "first_page_url")
    val firstPageUrl: String? = null,
    val from: Int? = null,
    @Json(name = "last_page")
    val lastPage: Int? = null,
    @Json(name = "last_page_url")
    val lastPageUrl: String? = null,
    val links: List<Link?>? = null,
    @Json(name = "next_page_url")
    val nextPageUrl: String? = null,
    val path: String? = null,
    @Json(name = "per_page")
    val perPage: String? = null,
    @Json(name = "prev_page_url")
    val prevPageUrl: Any? = null,
    val to: Int? = null,
    val total: Int? = null,
)
