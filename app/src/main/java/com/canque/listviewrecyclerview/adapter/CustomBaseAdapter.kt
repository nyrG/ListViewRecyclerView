package com.canque.listviewrecyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.canque.listviewrecyclerview.Fruit
import com.canque.listviewrecyclerview.FruitDetailActivity
import com.canque.listviewrecyclerview.R

class CustomBaseAdapter(private val context: Context, private val fruitList: List<Fruit>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return fruitList.size
    }

    override fun getItem(position: Int): Any {
        return fruitList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /*var view = convertView
        val viewHolder: ViewHolder
        if (view == null) {
            view = inflater.inflate(R.layout.custom_list_view, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.imageIcon),
                view.findViewById(R.id.customListTV)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        val fruit = getItem(position) as Fruit
        viewHolder.textView.text = fruit.fruitName
        viewHolder.imageView.setImageResource(fruit.fruitImg)

        view?.setOnClickListener {
            val fruit = getItem(position) as Fruit
            val intent = Intent(context, FruitDetailActivity::class.java)
            intent.putExtra("fruitName", fruit.fruitName)
            intent.putExtra("fruitImg", fruit.fruitImg)
            context.startActivity(intent)
        }

        return view!!*/

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.custom_list_view, null)

        val fruitName: TextView = view.findViewById(R.id.customListTextView)
        val fruitImg: ImageView = view.findViewById(R.id.customListImageView)

        fruitName.text = fruitList[position].fruitName
        fruitImg.setImageResource(fruitList[position].fruitImg)

        return view
    }

    private class ViewHolder(val imageView: ImageView, val textView: TextView)
}