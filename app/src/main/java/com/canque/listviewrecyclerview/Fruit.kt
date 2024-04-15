package com.canque.listviewrecyclerview

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Fruit(
    val fruitName: String,
    val fruitImg: Int,
): Serializable
