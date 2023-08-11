package com.emirhanemmez.common.data.local.di

import android.content.Context
import androidx.room.Room
import com.emirhanemmez.common.data.local.database.FavouriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideFavouriteDatabase(@ApplicationContext context: Context): FavouriteDatabase =
        Room.databaseBuilder(context, FavouriteDatabase::class.java, "favourite-db").build()
}