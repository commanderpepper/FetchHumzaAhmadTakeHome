package humzaahmad.fetchhumzaahmadtakehome.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import humzaahmad.fetchhumzaahmadtakehome.data.remote.FetchService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
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