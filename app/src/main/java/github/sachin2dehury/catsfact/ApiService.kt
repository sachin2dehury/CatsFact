package github.sachin2dehury.catsfact

import github.sachin2dehury.catsfact.paginated.CatFactsPaginatedResponse
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("facts")
    suspend fun getFactsPaginated(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
    ): Response<CatFactsPaginatedResponse>

    @GET("fact")
    suspend fun getSingleFact(): Response<CatsFactResponse>

    companion object {
        const val BASE_URL = "https://catfact.ninja/"
    }
}
