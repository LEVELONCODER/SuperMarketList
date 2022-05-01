package org.leveloncoder.supermarketlist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ItemsDb")
data class ItemDb(
    @ColumnInfo(name = "item_name") val itemName: String?,
    @ColumnInfo(name = "price") val price: Int?
)