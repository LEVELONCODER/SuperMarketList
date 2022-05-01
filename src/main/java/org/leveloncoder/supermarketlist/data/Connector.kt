package org.leveloncoder.supermarketlist.data

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import org.leveloncoder.supermarketlist.ItemsActivity
import org.leveloncoder.supermarketlist.data.dao.ItemDbDao
import org.leveloncoder.supermarketlist.data.entity.ItemDb

@Database(entities = [ItemDb::class], version = 1)
abstract class Connector : RoomDatabase()
{
    abstract fun itemDao(): ItemDbDao
}
