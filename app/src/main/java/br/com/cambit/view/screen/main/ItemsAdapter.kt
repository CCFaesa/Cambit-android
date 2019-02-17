package br.com.cambit.view.screen.main

import android.view.View
import br.com.cambit.R
import br.com.cambit.base.BaseAdapter
import br.com.cambit.base.extensions.loadImage
import br.com.cambit.data.model.Item
import kotlinx.android.synthetic.main.card_item.view.*

class ItemsAdapter : BaseAdapter<Item>() {
    override val layoutResource: Int
        get() = R.layout.card_item

    override fun bind(itemView: View, item: Item) {
        itemView.ciTxtItem.text = item.name
        itemView.ciImgItem.loadImage(item.image)
        itemView.ciTxtPrice.text = item.price.toString()
    }
}