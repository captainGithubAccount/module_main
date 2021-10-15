package com.example.module_main.page.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.App
import com.example.module_main.R
import com.example.module_main.data.bean.CompositionInfo
import com.example.module_main.databinding.ListitemPositionBinding
import com.example.module_main.event.fragment.RvCompositionAdapterListener
import com.example.module_main.event.fragment.RvCompositionAdapterPositionLintener

/*
* 作文列表适配器
* */
class RvCompositionAdapter(private val rvCompositionAdapterListener: RvCompositionAdapterListener) :
    ListAdapter<CompositionInfo, RvCompositionAdapter.CompositionInfoVh>(CompositionInfoDiffCallback()) {
    var selectIndex = -1
        set(value) {
            if (field != value) {
                notifyDataSetChanged()

//                notifyItemChanged(field)
                field = value
//                notifyItemChanged(value)
                // 遇到的问题只能通知改变所有item来更新视图
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositionInfoVh {
        val binding: ListitemPositionBinding =
            ListitemPositionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompositionInfoVh(binding)
    }

    override fun onBindViewHolder(holder: CompositionInfoVh, position: Int) {
        holder.pos = position

        val itemCompositionInfo: CompositionInfo = getItem(position)
        if (position == selectIndex) {
            holder.bindSelected(itemCompositionInfo)
        } else {
            holder.bind(itemCompositionInfo)
        }
    }

    inner class CompositionInfoVh(private val binding: ListitemPositionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var pos = -1

        init {
            binding.cvListitemRoot.setOnClickListener {
                selectIndex = pos
                binding.rvCompositionAdapterListener?.RvItemOnclick(it)
            }
        }

        fun bind(compositionInfo: CompositionInfo) {
            binding.compositionInfo = compositionInfo
//            rvCompositionAdapterPositionLintener.setPosition(pos)
            binding.rvCompositionAdapterListener = rvCompositionAdapterListener
            binding.executePendingBindings()
        }

        fun bindSelected(compositionInfo: CompositionInfo) {
            binding.compositionInfo = compositionInfo
//            rvCompositionAdapterPositionLintener.setPosition(pos)
            binding.rvCompositionAdapterListener = rvCompositionAdapterListener
            binding.executePendingBindings()
            binding.tvTitle.setTextColor(App.context.resources.getColor(R.color.nestscrollbar))
            binding.tvTitle.setTextColor(App.context.resources.getColor(R.color.nestscrollbar))
            binding.tvTimeWords.setTextColor(App.context.resources.getColor(R.color.nestscrollbar))
            binding.ivShowPositionDetail.setImageResource(R.drawable.ic_composition_list_shows_selected)
        }
    }
}

class CompositionInfoDiffCallback : DiffUtil.ItemCallback<CompositionInfo>() {
    override fun areItemsTheSame(oldItem: CompositionInfo, newItem: CompositionInfo): Boolean =
        (oldItem.id == newItem.id)

    override fun areContentsTheSame(
        oldItem: CompositionInfo,
        newItem: CompositionInfo
    ): Boolean = (newItem == oldItem)
}