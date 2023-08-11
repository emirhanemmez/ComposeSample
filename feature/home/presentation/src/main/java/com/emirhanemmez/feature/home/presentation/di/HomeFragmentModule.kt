package com.emirhanemmez.feature.home.presentation.di

import android.content.Context
import com.eemmez.localization.LocalizationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeFragmentModule {
    @Provides
    @Singleton
    fun provideLocalizationManager(@ApplicationContext context: Context): LocalizationManager =
        LocalizationManager(context)
}