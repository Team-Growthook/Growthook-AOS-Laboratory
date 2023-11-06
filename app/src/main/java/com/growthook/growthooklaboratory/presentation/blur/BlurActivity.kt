package com.growthook.growthooklaboratory.presentation.blur

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ActivityBlurBinding
import com.growthook.growthooklaboratory.presentation.blur.BlurAdapter.OnItemClickListener
import com.growthook.growthooklaboratory.util.base.BaseActivity

class BlurActivity : BaseActivity<ActivityBlurBinding>(R.layout.activity_blur) {

    private val viewModel by viewModels<BlurViewModel>()
    private lateinit var blurAdapter: BlurAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initMakeAdapter()
    }

    private fun initMakeAdapter() {
        blurAdapter = BlurAdapter(this)


        blurAdapter.setItemClickListener(object : OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val item = viewModel.mockBlurList[position]

                Toast.makeText(this@BlurActivity, "아이템: ${item.id}", Toast.LENGTH_SHORT).show()
                Log.d("check item.id: ", item.id)
            }
        })
        binding.rcvBlur.adapter = blurAdapter
        blurAdapter.setBlurList(viewModel.mockBlurList)

    }


}