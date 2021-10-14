package com.example.module_main.page.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.module_main.data.bean.CompositionInfo
import com.example.module_main.databinding.ListitemPositionBinding
import com.example.module_main.page.viewholder.CompositionInfoVh


class RvCompositionAdapter(): ListAdapter<CompositionInfo, CompositionInfoVh>(CompositionInfoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositionInfoVh {
        val binding: ListitemPositionBinding = ListitemPositionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CompositionInfoVh(binding)
    }

    override fun onBindViewHolder(holder: CompositionInfoVh, position: Int) {
        val itemCompositionInfo: CompositionInfo = getItem(position)
        holder.bind(itemCompositionInfo)
    }
}

class CompositionInfoDiffCallback : DiffUtil.ItemCallback<CompositionInfo>() {
    override fun areItemsTheSame(oldItem: CompositionInfo, newItem: CompositionInfo): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: CompositionInfo,
        newItem: CompositionInfo
    ): Boolean = newItem == oldItem
}