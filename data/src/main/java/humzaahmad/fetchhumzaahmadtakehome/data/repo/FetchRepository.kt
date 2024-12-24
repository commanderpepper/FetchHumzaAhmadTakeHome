package humzaahmad.fetchhumzaahmadtakehome.data.repo

interface FetchRepository {
    suspend fun getItems(): List<ItemRepoModel>
}