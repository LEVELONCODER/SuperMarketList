package org.leveloncoder.supermarketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import org.leveloncoder.supermarketlist.data.Connector

open class ItemsActivity : AppCompatActivity(), ItemsValues
{
    protected open var searchItem: EditText? = null
    protected open lateinit var emptyText: TextView
    protected open lateinit var addItems: Button
    protected open var itemsList: RecyclerView? = null
    protected open var itemName: EditText? = null
    protected open var itemPrice: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchItem = findViewById(R.id.searchItem)
        emptyText = findViewById(R.id.emptyText)
        itemsList = findViewById(R.id.itemsList)
        addItems = findViewById(R.id.addItems)
        itemName = findViewById(R.id.itemName)
        itemPrice = findViewById(R.id.itemPrice)

        searchItem?.setOnClickListener {
            getRequestFromList(itemsList)

            if(itemsList == null)
            {
                emptyText.isVisible
                addItems.isVisible
            } else
            {
                emptyText.isInvisible
                addItems.isInvisible
            }
        }
    }

    private val thisClass: ItemsActivity = ItemsActivity()
    private val db = Room.databaseBuilder(thisClass, Connector::class.java, "ItemsDb").build()

    override fun getInputData(name: String, price: Int, view: RecyclerView) {
        addItems.setOnClickListener {
            if(name.isEmpty())
            {
                Toast.makeText(this, "Введите указаное поле", Toast.LENGTH_LONG).show()
            } else if(price.toString().isEmpty())
            {
                Toast.makeText(this, "Введите указаное поле", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getRequestFromList(item: RecyclerView?)
    {
        if(itemsList?.isEmpty() == true)
        {
            emptyText.isVisible
            Toast.makeText(this, "Пусто", Toast.LENGTH_LONG).show()
            addItems.setOnClickListener {
                setContentView(R.layout.add_item)
            }
        } else
        {
            emptyText.isInvisible
            itemsList = show(itemsList)
            show(itemsList)
        }
    }

    override fun db(db: Room): Connector
    {
        val thisClass: ItemsActivity = ItemsActivity()
        return Room.databaseBuilder(thisClass, Connector::class.java, "ItemsDb").build()
    }

    override fun getItem(item: List<String>, name: String, price: Int)
    {
        Log.d("item_check", item.toString())
    }

    override fun itemValues(name: String, price: Int)
    {
        Log.d("value", "$name $price")
    }

    override fun show(view: RecyclerView?): RecyclerView?
    {
        return view
    }
}