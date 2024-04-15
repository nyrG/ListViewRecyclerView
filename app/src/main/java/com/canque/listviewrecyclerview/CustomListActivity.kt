package com.canque.listviewrecyclerview

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canque.listviewrecyclerview.adapter.CustomBaseAdapter
import com.canque.listviewrecyclerview.databinding.ActivityCustomListBinding
import java.io.Serializable

class CustomListActivity : AppCompatActivity() {
    /*private val fruitList = listOf( "Apple", "Banana", "Orange", "Mango", "Grapes", "Pineapple", "Strawberry", "Watermelon",
                                    "Peach", "Kiwi", "Cherry")
    private val fruitImages = intArrayOf(   R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.mango, R.drawable.grapes,
                                            R.drawable.grapes, R.drawable.pineapple, R.drawable.strawberry, R.drawable.watermelon,
                                            R.drawable.peach, R.drawable.kiwi, R.drawable.cherry)*/
    private lateinit var binding: ActivityCustomListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fruitList = listOf(
            Fruit("Apple", R.drawable.apple),
            Fruit("Banana", R.drawable.banana),
            Fruit("Orange", R.drawable.orange),
            Fruit("Mango", R.drawable.mango),
            Fruit("Grapes", R.drawable.grapes),
            Fruit("Pineapple", R.drawable.pineapple),
            Fruit("Strawberry", R.drawable.strawberry),
            Fruit("Watermelon", R.drawable.watermelon),
            Fruit("Peach", R.drawable.peach),
            Fruit("Kiwi", R.drawable.kiwi),
            Fruit("Cherry", R.drawable.cherry),
        )
        val customAdapter = CustomBaseAdapter(this, fruitList)
        binding.customListView.adapter = customAdapter
        binding.customListView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            val intent = Intent(this, FruitDetailActivity::class.java)
            intent.putExtra("FRUIT", fruit as Serializable)
            startActivity(intent)
        }
    }
}