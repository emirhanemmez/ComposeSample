package com.emirhanemmez.feature.home.presentation.di

import android.content.Context
import com.eemmez.localization.LocalizationManager
import com.emirhanemmez.feature.home.presentation.mapper.ErrorMessageMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeFragmentModule {
    @Provides
    @ViewModelScoped
    fun provideLocalizationManager(@ApplicationContext context: Context): LocalizationManager =
        LocalizationManager(context)

    @Provides
    @ViewModelScoped
    fun provideErrorMessageMapper(localizationManager: LocalizationManager): ErrorMessageMapper =
        ErrorMessageMapper(localizationManager)
}