package com.growthook.growthooklaboratory.presentation.blur


import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.Transliterator.Position
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ItemBlurListBinding
import com.growthook.growthooklaboratory.domain.entity.BlurData


class BlurAdapter(context: Context) : RecyclerView.Adapter<BlurAdapter.BlurViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    private var blurList: List<BlurData> = emptyList()

    inner class BlurViewHolder(
        private val binding: ItemBlurListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: BlurData) {
            binding.tvBlurItem.text = data.id

            binding.root.setOnClickListener {
                selectItem(data.id, itemView)
                itemClickListener.let { it(data) }
            }

        }
    }
    private var selectedItem = arrayListOf<String>()

    fun selectItem(positionId: String, view: View) {
        if (selectedItem.contains(positionId)) {
            selectedItem.removeAt(selectedItem.indexOf(positionId))
            changeBackground(view, false)
            Log.d("check pop: ", positionId)
        } else {
            selectedItem.add(positionId)
            changeBackground(view, true)
            Log.d("check push: ", positionId)
        }
    }

    @SuppressLint("ResourceType")
    fun changeBackground(view : View, bool: Boolean) {
        when (bool) {
            true -> {
                view.background = ContextCompat.getDrawable(view.context, R.drawable.item_blur_checked)
            }
            false -> {
                view.background = ContextCompat.getDrawable(view.context, R.drawable.item_blur_background_gray)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlurViewHolder {
        val binding = ItemBlurListBinding.inflate(inflater, parent, false)
        return BlurViewHolder(binding)
    }

    override fun getItemCount() = blurList.size

    override fun onBindViewHolder(holder: BlurViewHolder, position: Int) {
        val item = blurList[position]

        holder.bind(item)
    }

    fun setBlurList(blurList: List<BlurData>) {
        this.blurList = blurList.toList()
        notifyDataSetChanged()
    }



//    interface OnItemClickListener {
//        fun onClick(v: View, position: Int)
//    }
    private lateinit var itemClickListener : ((BlurData) -> Unit)

    fun setItemClickListener(itemClickListener: (BlurData) -> Unit) {
        this.itemClickListener = itemClickListener
    }
}

