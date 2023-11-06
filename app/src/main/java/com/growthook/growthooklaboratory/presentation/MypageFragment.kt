package com.growthook.growthooklaboratory.presentation

import android.os.Bundle
import android.view.View
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.FragmentMypageBinding
import com.growthook.growthooklaboratory.domain.entity.Insight
import com.growthook.growthooklaboratory.presentation.gaeun.MultiSelectAdapter
import com.growthook.growthooklaboratory.util.base.BaseFragment

class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private val dummyData = listOf(
        Insight(true, "연습1"),
        Insight(true, "연습2"),
        Insight(true, "연습3"),
        Insight(true, "연습4"),
        Insight(true, "연습5"),
        Insight(true, "연습6"),
        Insight(true, "연습7"),
        Insight(true, "연습8"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        val multiSelectAdapter = MultiSelectAdapter()
        multiSelectAdapter.submitList(dummyData)
        binding.rvHomeMain.adapter = multiSelectAdapter
    }
}
