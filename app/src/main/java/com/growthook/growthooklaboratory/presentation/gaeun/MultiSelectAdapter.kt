package com.growthook.growthooklaboratory.presentation.gaeun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ItemGaeunInsightBinding
import com.growthook.growthooklaboratory.domain.entity.Insight
import com.growthook.growthooklaboratory.util.extension.ItemDiffCallback

class MultiSelectAdapter :
    ListAdapter<Insight, MultiSelectAdapter.MultiSelectViewHolder>(diffCallback) {

    private var onItemClickListener: ((Insight) -> Unit)? = null
    var selectedInsight = mutableListOf<Insight>()

    val selectedInsightSize = selectedInsight.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiSelectViewHolder {
        val binding: ItemGaeunInsightBinding =
            ItemGaeunInsightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MultiSelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MultiSelectViewHolder, position: Int) {
        return holder.onBind(currentList[position])
    }

    inner class MultiSelectViewHolder(private val binding: ItemGaeunInsightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Insight) {
            binding.tvHomeTitle.text = item.title
            binding.root.setOnClickListener {
                applySelection(binding, item)
                onItemClickListener?.let { it(item) }
            }
        }
    }

    private fun applySelection(binding: ItemGaeunInsightBinding, insight: Insight) {
        if (selectedInsight.contains(insight)) {
            selectedInsight.remove(insight)
            changeBackground(binding, R.color.example_gray)
        } else {
            selectedInsight.add(insight)
            changeBackground(binding, R.color.example_green)
        }
        binding.hasPendingBindings()
    }

    private fun changeBackground(binding: ItemGaeunInsightBinding, resId: Int) {
        binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, resId))
    }

    fun setOnItemClickListener(listener: (Insight) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val diffCallback =
            ItemDiffCallback<Insight>(
                onContentsTheSame = { old, new -> old == new },
                onItemsTheSame = { old, new -> old == new },
            )
    }
}
