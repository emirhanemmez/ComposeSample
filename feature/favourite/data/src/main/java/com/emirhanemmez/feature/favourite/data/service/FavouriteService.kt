package com.emirhanemmez.feature.favourite.data.service

import com.emirhanemmez.common.data.local.database.FavouriteDatabase
import com.emirhanemmez.common.data.local.dto.FavouriteItem
import javax.inject.Inject

class FavouriteService @Inject constructor(
    private val favouriteDatabase: FavouriteDatabase
) {
    suspend fun getAll(): List<FavouriteItem> {
        return favouriteDatabase.favouriteItemDao().getAll()
    }

    suspend fun delete(favouriteItem: FavouriteItem) {
        favouriteDatabase.favouriteItemDao().delete(favouriteItem.name, favouriteItem.imageURL)
    }
}