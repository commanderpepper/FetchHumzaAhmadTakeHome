package humzaahmad.fetchhumzaahmadtakehome.data.repo

import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchRemoteDataSource
import javax.inject.Inject

class FetchRepositoryImpl @Inject constructor(private val remoteDataSource: FetchRemoteDataSource) : FetchRepository {
    override suspend fun getItems(): List<ItemRepoModel> {
        return remoteDataSource.getItems().map {
            ItemRepoModel(id = it.id, listId = it.listId, name = it.name)
        }
    }
}