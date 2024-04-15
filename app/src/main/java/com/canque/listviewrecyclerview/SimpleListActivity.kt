package com.canque.listviewrecyclerview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canque.listviewrecyclerview.databinding.ActivityMainBinding
import com.canque.listviewrecyclerview.databinding.ActivitySimpleListBinding

class SimpleListActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private val fruitList = listOf( "Apple", "Banana", "Orange", "Mango", "Grapes", "Pineapple", "Strawberry", "Watermelon",
                                    "Peach", "Kiwi", "Cherry", "Pear", "Lemon", "Plum", "Blueberry")
    private lateinit var binding: ActivitySimpleListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySimpleListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listView = findViewById(R.id.simpleListView)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            R.layout.simple_list_view,
            R.id.listTV,
            fruitList
        )
        listView.adapter = arrayAdapter
    }
}