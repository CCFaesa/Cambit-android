package br.com.cambit.view.screen.itemdetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cambit.R
import br.com.cambit.base.extensions.extra
import br.com.cambit.base.extensions.loadImage
import br.com.cambit.data.model.Item
import kotlinx.android.synthetic.main.activity_item_details.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ItemDetailsActivity : AppCompatActivity(), ItemDetailsContract.View {
    override val presenter by inject<ItemDetailsPresenter> { parametersOf(this) }

    private val item by extra<Item>(EXTRA_ITEM)

    companion object {
        private const val EXTRA_ITEM = "ITEM"

        fun startActivity(context: Context, item: Item) {
            val intent = Intent(context, ItemDetailsActivity::class.java).apply {
                putExtra(EXTRA_ITEM, item)
            }

            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        setupViews()
        presenter.test()
    }

    private fun setupViews() {
        idImgItem.loadImage(item.image)
        idTxtName.text = item.name
        idTxtPrice.text = item.price.toString()
        idTxtAddress.text = item.address
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
