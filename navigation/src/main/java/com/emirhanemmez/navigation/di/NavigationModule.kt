package com.emirhanemmez.navigation.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object NavigationModule {
    @Provides
    @ViewModelScoped
    fun provideGson(): Gson = Gson()
}