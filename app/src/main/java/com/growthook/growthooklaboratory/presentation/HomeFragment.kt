package com.growthook.growthooklaboratory.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.FragmentHomeBinding
import com.growthook.growthooklaboratory.util.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val homeAdapter = HomeAdapter(::clickItem)
        binding.rcvHomeMain.also {
            it.adapter = homeAdapter
            it.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun clickItem() {
        val bottomSheetDialog = HomeBottomsheetFragment()
        bottomSheetDialog.show(parentFragmentManager, "show")
    }
}
