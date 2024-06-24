package com.example.shopnet.presenter.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopnet.R
import com.example.shopnet.databinding.ItemProductBinding
import com.example.shopnet.domain.product.ProductsItem


class ProductsAdapter(private val onItemClick :(String, String, String, String, String, String)-> Unit) : ListAdapter<ProductsItem,
        ProductsAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.from_left)
        holder.itemView.startAnimation(animation)

    }

    inner class ViewHolder(private val itemBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(productsItem: ProductsItem) {
                    itemBinding.productName.text = productsItem.title
                     itemBinding.priceProduct.text=productsItem.price.toString()+" EGP"
                    Glide.with(itemBinding.root.context).load(productsItem.image)
                        .into(itemBinding.productImage)
                    itemBinding.root.setOnClickListener {
                         onItemClick(productsItem.title,productsItem.image,productsItem.description
                         ,productsItem.category, productsItem.price.toString(),productsItem.rating.rate.toString())

                    }
                }
            }
        }

    class CategoryDiffCallback : DiffUtil.ItemCallback<ProductsItem>() {
        override fun areItemsTheSame(
            oldItem: ProductsItem,
            newItem: ProductsItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductsItem,
            newItem: ProductsItem
        ): Boolean {
            return oldItem == newItem
        }
    }





