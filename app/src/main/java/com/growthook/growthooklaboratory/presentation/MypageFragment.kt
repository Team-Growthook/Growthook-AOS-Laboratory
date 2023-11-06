package com.growthook.growthooklaboratory.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.FragmentMypageBinding
import com.growthook.growthooklaboratory.presentation.gaeun.MultiSelectAdapter
import com.growthook.growthooklaboratory.presentation.gaeun.MyPageViewModel
import com.growthook.growthooklaboratory.util.base.BaseFragment

class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private val viewModel by viewModels<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        val multiSelectAdapter = MultiSelectAdapter()
        multiSelectAdapter.submitList(viewModel.dummyData)
        binding.rvMypageMain.adapter = multiSelectAdapter
        allItemCheckBox(multiSelectAdapter)
    }

    private fun allItemCheckBox(multiSelectAdapter: MultiSelectAdapter) {
        binding.chbMypageSelect.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> multiSelectAdapter.selectedInsight = viewModel.dummyData
                false -> multiSelectAdapter.selectedInsight.clear()
            }
            multiSelectAdapter.submitList(viewModel.dummyData)
        }
        multiSelectAdapter.setOnItemClickListener {
            binding.chbMypageSelect.isSelected = true
        }
    }
}
