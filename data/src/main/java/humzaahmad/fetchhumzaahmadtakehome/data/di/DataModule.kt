package humzaahmad.fetchhumzaahmadtakehome.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchRemoteDataSource
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchRemoteDataSourceImpl
import humzaahmad.fetchhumzaahmadtakehome.data.repo.FetchRepository
import humzaahmad.fetchhumzaahmadtakehome.data.repo.FetchRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun bindsFetchRepository(fetchRepositoryImpl: FetchRepositoryImpl): FetchRepository {
        return fetchRepositoryImpl
    }

    @Singleton
    @Provides
    fun bindsFetchRemoteDataSource(fetchRemoteDataSourceImpl: FetchRemoteDataSourceImpl): FetchRemoteDataSource {
        return fetchRemoteDataSourceImpl
    }
}