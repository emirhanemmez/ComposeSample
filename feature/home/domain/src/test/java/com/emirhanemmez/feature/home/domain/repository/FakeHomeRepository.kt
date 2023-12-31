package com.emirhanemmez.feature.home.domain.repository

import com.emirhanemmez.core.Result
import com.emirhanemmez.feature.home.domain.entity.GetListResponseEntity
import com.emirhanemmez.feature.home.domain.entity.HomeError
import com.emirhanemmez.feature.home.domain.entity.ListItemEntity

class FakeHomeRepository : HomeRepository {
    private val listData = listOf(
        ListItemEntity("kedi1", "image1"),
        ListItemEntity("kedi2", "image2"),
        ListItemEntity("kedi3", "image3"),
        ListItemEntity("kedi4", "image4"),
        ListItemEntity("kedi5", "image5"),
        ListItemEntity("kedi6", "image6"),
        ListItemEntity("kedi7", "image7"),
        ListItemEntity("kedi8", "image8"),
        ListItemEntity("kedi9", "image9"),
        ListItemEntity("kedi10", "image10"),
    )

    override fun getList(
        pageNumber: Int?,
        search: String?
    ): FlowResult<GetListResponseEntity, HomeError>> =
        FlowResult<GetListResponseEntity, HomeError>> {
            emit(
                Result.Success(
                    GetListResponseEntity(
                        0, true, listData.filter { it.name.contains(search ?: "") }
                    )
                )
            )
        }.onStart {
            emit(Result.Loading())
        }

    override fun addFavourite(listItemEntity: ListItemEntity): FlowResult<Unit, HomeError>> =
        FlowResult<Unit, HomeError>> {
            emit(Result.Success(Unit))
        }.onStart {
            emit(Result.Loading())
        }
}