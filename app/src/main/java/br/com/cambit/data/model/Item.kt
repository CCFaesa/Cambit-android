package br.com.cambit.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val name: String,
    val price: Double,
    val image: String,
    val address: String
) : Parcelable