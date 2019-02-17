package br.com.cambit.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseAdapter<T>.Holder<T>>() {

    var onItemClick: ((T) -> Unit) = {}

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract val layoutResource: Int
    abstract fun bind(itemView: View, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(parent.context).inflate(layoutResource, parent, false), ::bind)

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder<T>, position: Int) {
        holder.render(data[position])
    }

    inner class Holder<T>(itemView: View, val bind: (View, T) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClick(data[adapterPosition])
            }
        }

        fun render(item: T) {
            bind(itemView, item)
        }
    }
}