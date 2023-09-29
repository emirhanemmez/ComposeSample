package com.emirhanemmez.feature.home.data.service

import com.emirhanemmez.common.data.local.database.FavouriteDatabase
import com.emirhanemmez.common.data.local.dto.FavouriteItem
import com.emirhanemmez.common.data.remote.dto.Response
import com.emirhanemmez.feature.home.data.dto.GetListResponse
import com.emirhanemmez.feature.home.data.dto.HomeErrorCode
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

class HomeService @Inject constructor(
    private val client: HttpClient,
    private val favouriteDatabase: FavouriteDatabase
) {
    suspend fun getList(
        pageNumber: Int?,
        search: String?
    ): Response<GetListResponse, HomeErrorCode> =
        client.get {
            url("list")
            parameter("pageNumber", pageNumber)
            parameter("search", search)
        }.body()

    suspend fun getFavourites(): List<FavouriteItem> {
        return favouriteDatabase.favouriteItemDao().getAll()
    }

    suspend fun addFavourite(favouriteItem: FavouriteItem) {
        favouriteDatabase.favouriteItemDao().insert(favouriteItem)
    }

    suspend fun deleteFavourite(favouriteItem: FavouriteItem) {
        favouriteDatabase.favouriteItemDao().delete(favouriteItem.name, favouriteItem.imageURL)
    }
}