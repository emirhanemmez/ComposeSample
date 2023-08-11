package com.emirhanemmez.feature.favourite.data.di

import com.emirhanemmez.common.data.local.di.IoDispatcher
import com.emirhanemmez.feature.favourite.data.repository.FavouriteRepositoryImpl
import com.emirhanemmez.feature.favourite.data.service.FavouriteService
import com.emirhanemmez.feature.favourite.domain.repository.FavouriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavouriteRepositoryModule {
    @Provides
    @Singleton
    fun provideFavouriteRepository(
        favouriteService: FavouriteService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): FavouriteRepository =
        FavouriteRepositoryImpl(favouriteService, ioDispatcher)
}