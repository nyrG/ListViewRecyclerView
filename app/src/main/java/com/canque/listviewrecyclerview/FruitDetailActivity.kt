package com.canque.listviewrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canque.listviewrecyclerview.databinding.ActivityFruitDetailBinding

class FruitDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFruitDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFruitDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fruit = intent.getSerializableExtra("FRUIT") as Fruit

        binding.fruitTextView.text = fruit.fruitName
        binding.fruitImageView.setImageResource(fruit.fruitImg)
    }
}