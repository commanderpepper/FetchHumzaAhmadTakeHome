package humzaahmad.fetchhumzaahmadtakehome.data.remote

import retrofit2.http.GET

interface FetchService {
    @GET("hiring.json")
    suspend fun getItems(): List<ItemDataModel>
}