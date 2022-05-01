package org.leveloncoder.supermarketlist.data.dao

import androidx.room.Dao
import androidx.room.Query
import org.leveloncoder.supermarketlist.data.entity.ItemDb

@Dao
interface ItemDbDao
{

    @Query("SELECT * FROM ItemsDb")
    fun getList(): List<ItemDb>
}