package org.leveloncoder.supermarketlist

import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import org.leveloncoder.supermarketlist.data.Connector

interface ItemsValues
{
    fun itemValues(name: String, price: Int)
    fun show(view: RecyclerView?) : RecyclerView?
    fun db(db: Room): Connector
    fun getItem(item: List<String>, name: String, price: Int)
    fun getRequestFromList(item: RecyclerView?)
    fun getInputData(name: String, price: Int, view: RecyclerView)
}