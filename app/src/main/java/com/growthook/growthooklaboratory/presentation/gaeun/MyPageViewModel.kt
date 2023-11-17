package com.growthook.growthooklaboratory.presentation.gaeun

import androidx.lifecycle.ViewModel
import com.growthook.growthooklaboratory.domain.entity.Insight

class MyPageViewModel : ViewModel() {

    val dummyData = mutableListOf(
        Insight(true, "연습1"),
        Insight(true, "연습2"),
        Insight(true, "연습3"),
        Insight(true, "연습4"),
        Insight(true, "연습5"),
        Insight(true, "연습6"),
        Insight(true, "연습7"),
        Insight(true, "연습8"),
        Insight(true, "연습9"),
        Insight(true, "연습10"),
    )

}
