package com.growthook.growthooklaboratory.presentation.blur

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ActivityBlurBinding
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
        binding.rcvBlur.adapter = blurAdapter

        blurAdapter.setItemClickListener {
            Toast.makeText(this@BlurActivity, "아이템: ${it.id}", Toast.LENGTH_SHORT).show()
        }

        blurAdapter.setBlurList(viewModel.mockBlurList)

    }


}