package com.growthook.growthooklaboratory.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.databinding.ItemHomeBinding

class HomeAdapter(private val selectedItem: () -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(private val binding: ItemHomeBinding, private val selectedItem: () -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() = with(binding) {
            clHomeBackground.setOnLongClickListener {
                selectedItem()
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, selectedItem)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int = 9
}
