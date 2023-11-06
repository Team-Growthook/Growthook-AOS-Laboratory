package com.growthook.growthooklaboratory.presentation.blur

import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.databinding.ItemBlurListBinding
import com.growthook.growthooklaboratory.domain.entity.BlurData


class BlurViewHolder(
    private val binding: ItemBlurListBinding
) : RecyclerView.ViewHolder(binding.root) {

    //private var listener : MainBlurAdapter.OnItemClickListener? = null

    fun onBind(data: BlurData) {
        binding.tvBlurItem.text = data.id
    }
}