package humzaahmad.fetchhumzaahmadtakehome.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchRemoteDataSource
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchRemoteDataSourceImpl
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchService
import humzaahmad.fetchhumzaahmadtakehome.data.repo.FetchRepository
import humzaahmad.fetchhumzaahmadtakehome.data.repo.FetchRepositoryImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Binds
    fun bindsFetchRepository(fetchRepositoryImpl: FetchRepositoryImpl): FetchRepository {
        return fetchRepositoryImpl
    }

    @Singleton
    @Binds
    fun bindsFetchRemoteDataSource(fetchRemoteDataSourceImpl: FetchRemoteDataSourceImpl): FetchRemoteDataSource {
        return fetchRemoteDataSourceImpl
    }

    @Singleton
    @Provides
    fun providesFetchService(): FetchService {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()) )
            .build()
            .create(FetchService::class.java)
    }
}