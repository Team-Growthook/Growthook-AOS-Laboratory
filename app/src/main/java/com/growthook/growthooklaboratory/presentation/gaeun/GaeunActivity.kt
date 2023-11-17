package com.growthook.growthooklaboratory.presentation.gaeun

import android.os.Bundle
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ActivityGaeunBinding
import com.growthook.growthooklaboratory.domain.entity.Insight
import com.growthook.growthooklaboratory.util.base.BaseActivity

class GaeunActivity : BaseActivity<ActivityGaeunBinding>(R.layout.activity_gaeun) {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val multiSelectAdapter = MultiSelectAdapter()
        multiSelectAdapter.submitList(dummyData)
        binding.rvHomeMain.adapter = multiSelectAdapter*/
    }
}
