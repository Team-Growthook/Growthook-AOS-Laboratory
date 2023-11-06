package com.growthook.growthooklaboratory.presentation

import android.os.Bundle
import android.view.View
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.FragmentHomeBinding
import com.growthook.growthooklaboratory.util.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListner()
    }

    private fun clickListner() {
        binding.viewHomeMain.setOnClickListener {
            val bottomSheetDialog = HomeBottomsheetFragment()
            bottomSheetDialog.show(parentFragmentManager, "show")
        }
    }
}
