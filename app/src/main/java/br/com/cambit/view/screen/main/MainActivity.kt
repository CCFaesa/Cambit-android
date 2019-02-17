package br.com.cambit.view.screen.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cambit.R
import br.com.cambit.data.model.Item
import br.com.cambit.view.screen.itemdetails.ItemDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {

    override val presenter by inject<MainPresenter> { parametersOf(this) }
    private val adapter by lazy { ItemsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        presenter.loadItems()
    }

    override fun onLoadedItems(items: List<Item>) {
        adapter.data = items
    }

    override fun showLoadItemsDialog() {
        mainTxtExample.setText(R.string.loading)
    }

    override fun hideLoadItemsDialog() {
        mainTxtExample.setText(R.string.ready)
    }

    override fun showMessageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setupViews() {
        mainTxtExample.text = resources.getText(R.string.temp2_text)
        mainRecItems.layoutManager = LinearLayoutManager(this)
        mainRecItems.adapter = adapter

        adapter.onItemClick = { item ->
            ItemDetailsActivity.startActivity(this, item)
        }
    }
}
