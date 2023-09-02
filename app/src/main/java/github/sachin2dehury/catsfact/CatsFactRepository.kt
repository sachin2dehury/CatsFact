package github.sachin2dehury.catsfact

class CatsFactRepository(private val service: ApiService) {

    suspend fun getSingleFact() = service.getSingleFact()

    suspend fun getFactsPaginated(page: Int, limit: Int) = service.getFactsPaginated(page, limit)
}
