package humzaahmad.fetchhumzaahmadtakehome.data.remote

import javax.inject.Inject

class FetchRemoteDataSourceImpl @Inject constructor(private val fetchService: FetchService) :
    FetchRemoteDataSource {
    override suspend fun getItems(): List<ItemDataModel> {
        return fetchService.getItems()
    }
}