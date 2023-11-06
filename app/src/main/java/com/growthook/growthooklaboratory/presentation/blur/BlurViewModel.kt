package com.growthook.growthooklaboratory.presentation.blur

import androidx.lifecycle.ViewModel
import com.growthook.growthooklaboratory.domain.entity.BlurData

class BlurViewModel : ViewModel() {

    private val _mockBlurList = listOf<BlurData>(
        BlurData("item 1"),
        BlurData("item 2"),
        BlurData("item 3"),
        BlurData("item 4"),
        BlurData("item 5"),
        BlurData("item 6"),
        BlurData("item 7"),
        BlurData("item 8"),
        BlurData("item 9"),
        BlurData("item 10"),
        BlurData("item 11"),
        BlurData("item 12"),
        BlurData("item 13"),
        BlurData("item 14"),
        BlurData("item 15"),
    )

    val mockBlurList : List<BlurData>
        get() = _mockBlurList

}