package humzaahmad.fetchhumzaahmadtakehome.data.remote

interface FetchRemoteDataSource {
    suspend fun getItems(): List<ItemDataModel>
}