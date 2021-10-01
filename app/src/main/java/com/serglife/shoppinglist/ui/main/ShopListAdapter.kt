package com.serglife.shoppinglist.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.serglife.shoppinglist.R
import com.serglife.shoppinglist.data.entity.ShopItem
import com.serglife.shoppinglist.databinding.ItemShopDisabledBinding
import com.serglife.shoppinglist.databinding.ItemShopEnableBinding

class ShopListAdapter : ListAdapter<ShopItem, ShopListViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_ENABLE -> R.layout.item_shop_enable
            VIEW_TYPE_DISABLE -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown layout $viewType")
        }

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
        return ShopListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)
        val binding = holder.binding

        binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
            true
        }

        when(binding){
            is ItemShopDisabledBinding -> {
                binding.shopItem = shopItem
            }
            is ItemShopEnableBinding -> {
                binding.shopItem = shopItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enable) VIEW_TYPE_ENABLE else VIEW_TYPE_DISABLE
    }

    companion object {
        const val VIEW_TYPE_ENABLE = 0
        const val VIEW_TYPE_DISABLE = 1
        const val MAX_SIZE_POOL = 10
    }
}