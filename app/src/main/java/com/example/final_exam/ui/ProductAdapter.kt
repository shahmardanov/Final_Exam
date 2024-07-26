package com.example.test.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.final_exam.databinding.ItemProductBinding
import com.example.final_exam.model.CoffeeItem
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList = arrayListOf<CoffeeItem>()
    lateinit var onClickItem: (CoffeeItem) -> Unit

    inner class ProductViewHolder(val itemProduct: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProduct.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.itemProduct.item = item

        holder.itemProduct.button.setOnClickListener {
            onClickItem(item)
        }
    }

    fun updateList(newList: List<CoffeeItem>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}