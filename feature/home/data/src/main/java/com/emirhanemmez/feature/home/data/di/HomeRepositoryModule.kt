package com.emirhanemmez.feature.home.data.di

import com.emirhanemmez.common.data.remote.di.IoDispatcher
import com.emirhanemmez.feature.home.data.repository.HomeRepositoryImpl
import com.emirhanemmez.feature.home.data.service.HomeService
import com.emirhanemmez.feature.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(
        homeService: HomeService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): HomeRepository =
        HomeRepositoryImpl(homeService, ioDispatcher)
}