package com.growthook.growthooklaboratory.presentation.blur


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.databinding.ItemBlurListBinding
import com.growthook.growthooklaboratory.domain.entity.BlurData


class BlurAdapter(context : Context) : RecyclerView.Adapter<BlurViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    private var blurList: List<BlurData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlurViewHolder {
        val binding = ItemBlurListBinding.inflate(inflater, parent, false)
        return BlurViewHolder(binding)
    }

    override fun getItemCount() = blurList.size

    override fun onBindViewHolder(holder: BlurViewHolder, position: Int) {
        val item = blurList[position]

        //
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }

        holder.onBind(item)
    }

    fun setBlurList(blurList: List<BlurData>) {
        this.blurList = blurList.toList()
        notifyDataSetChanged()
    }

    //ClickListener
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}

