package com.emirhanemmez.common.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emirhanemmez.common.data.local.dto.FavouriteItem

@Dao
interface FavouriteItemDao {
    @Query("SELECT * from FavouriteItems")
    suspend fun getAll(): List<FavouriteItem>

    @Insert
    suspend fun insert(favouriteItem: FavouriteItem)

    @Query("DELETE from FavouriteItems where name = :name AND image_url = :imageURL")
    suspend fun delete(name: String, imageURL: String)
}