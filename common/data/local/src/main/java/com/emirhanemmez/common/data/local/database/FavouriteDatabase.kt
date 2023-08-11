package com.emirhanemmez.common.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emirhanemmez.common.data.local.dao.FavouriteItemDao
import com.emirhanemmez.common.data.local.dto.FavouriteItem

@Database(entities = [FavouriteItem::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteItemDao(): FavouriteItemDao
}