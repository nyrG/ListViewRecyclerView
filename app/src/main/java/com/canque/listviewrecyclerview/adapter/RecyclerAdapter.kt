package com.canque.listviewrecyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canque.listviewrecyclerview.Fruit
import com.canque.listviewrecyclerview.FruitDetailActivity
import com.canque.listviewrecyclerview.databinding.RecyclerViewLayoutBinding

class RecyclerAdapter(private val context: Context, private val fruitList: MutableList<Fruit>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: RecyclerViewLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(fruit: Fruit) {
            binding.recyclerListTextView.text = fruit.fruitName
            binding.recyclerListImageView.setImageResource(fruit.fruitImg)
            binding.listItem.setOnClickListener{
                val intent = Intent(context, FruitDetailActivity::class.java)
                intent.putExtra("FRUIT", fruit)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position])
    }

    override fun getItemCount() = fruitList.size
}