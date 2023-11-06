package com.growthook.growthooklaboratory.presentation.gaeun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.databinding.ItemGaeunInsightBinding
import com.growthook.growthooklaboratory.domain.entity.Insight
import com.growthook.growthooklaboratory.util.extension.ItemDiffCallback

class MultiSelectAdapter :
    ListAdapter<Insight, MultiSelectAdapter.MultiSelectViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiSelectViewHolder {
        val binding: ItemGaeunInsightBinding =
            ItemGaeunInsightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MultiSelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MultiSelectViewHolder, position: Int) {
        return holder.onBind(currentList[position])
    }

    class MultiSelectViewHolder(private val binding: ItemGaeunInsightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Insight) {
            binding.tvHomeTitle.text = item.title
        }
    }

    companion object {
        private val diffCallback =
            ItemDiffCallback<Insight>(
                onContentsTheSame = { old, new -> old == new },
                onItemsTheSame = { old, new -> old == new },
            )
    }
}
