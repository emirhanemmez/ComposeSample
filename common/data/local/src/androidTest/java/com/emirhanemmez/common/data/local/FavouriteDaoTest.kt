package com.emirhanemmez.common.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.emirhanemmez.common.data.local.dao.FavouriteItemDao
import com.emirhanemmez.common.data.local.database.FavouriteDatabase
import com.emirhanemmez.common.data.local.dto.FavouriteItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class FavouriteDaoTest {
    private lateinit var favouriteDatabase: FavouriteDatabase
    private lateinit var favouriteItemDao: FavouriteItemDao

    @Before
    fun setup() {
        favouriteDatabase = Room.inMemoryDatabaseBuilder(
            context = ApplicationProvider.getApplicationContext(),
            klass = FavouriteDatabase::class.java
        ).allowMainThreadQueries().build()

        favouriteItemDao = favouriteDatabase.favouriteItemDao()
    }

    @After
    fun tearDown() {
        favouriteDatabase.close()
    }

    @Test
    fun insertItem() {
        runTest {
            val favouriteItem = FavouriteItem(id = 0, name = "test", imageURL = "image")
            favouriteItemDao.insert(favouriteItem)

            val favouriteList = favouriteItemDao.getAll()
            assert(favouriteList.contains(favouriteItem))
        }
    }

    @Test
    fun deleteItem() {
        runTest {
            val favouriteItem = FavouriteItem(name = "test", imageURL = "image")
            favouriteItemDao.insert(favouriteItem)
            favouriteItemDao.delete("test", "image")

            val favouriteList = favouriteItemDao.getAll()
            assert(favouriteList.contains(favouriteItem).not())
        }
    }
}