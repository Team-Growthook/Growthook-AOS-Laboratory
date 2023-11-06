package com.growthook.growthooklaboratory.presentation.blur

import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ActivityBlurBinding
import com.growthook.growthooklaboratory.util.base.BaseActivity

class BlurActivity : BaseActivity<ActivityBlurBinding>(R.layout.activity_blur){

    private val viewModel by viewModels<BlurViewModel>()
    private lateinit var blurAdapter: BlurAdapter

    private lateinit var blurFilter : BlurMaskFilter
    private lateinit var paint : Paint


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initMakeAdapter()
    }

    private fun initMakeAdapter() {
        blurAdapter = BlurAdapter(this)
        blurAdapter.setItemClickListener(object : BlurAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val item = viewModel.mockBlurList[position]

                //initMakeBlur()
                paint = Paint()
                paint.setColor(Color.GRAY)
                blurFilter = BlurMaskFilter(10F, BlurMaskFilter.Blur.NORMAL)
                blurAdapter.apply { paint.maskFilter = blurFilter }
                //blurAdapter.apply {paint.setMaskFilter(blurFilter)}

                item.apply { paint.maskFilter = blurFilter }

                item.apply { paint.setMaskFilter(blurFilter) }

                Toast.makeText(this@BlurActivity, "아이템: ${item.id}", Toast.LENGTH_SHORT).show()

            }
        })

        binding.rcvBlur.adapter = blurAdapter
        blurAdapter.setBlurList(viewModel.mockBlurList)
    }

    private fun initMakeBlur() {
        paint = Paint()
        paint.setColor(Color.GRAY)
        blurFilter = BlurMaskFilter(10F, BlurMaskFilter.Blur.NORMAL)

        blurAdapter.apply {
            paint.setMaskFilter(blurFilter)
        }
    }

}