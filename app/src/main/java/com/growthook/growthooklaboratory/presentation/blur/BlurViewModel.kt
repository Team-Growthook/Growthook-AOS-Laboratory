package com.growthook.growthooklaboratory.presentation.blur

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.growthook.growthooklaboratory.domain.entity.BlurData

class BlurViewModel : ViewModel() {

    private val _mockBlurList = listOf<BlurData>(
        BlurData("1","item 1"),
        BlurData("2","item 2"),
        BlurData("3","item 3"),
        BlurData("4","item 4"),
        BlurData("5", "item 5"),
        BlurData("6", "item 6"),
        BlurData("7","item 7"),
        BlurData("8", "item 8"),
        BlurData("9", "item 9"),
        BlurData("10", "item 10"),
        BlurData("11", "item 11"),
        BlurData("12", "item 12"),
        BlurData("13", "item 13"),
        BlurData("14", "item 14"),
        BlurData("15", "item 15"),
    )

    val mockBlurList : List<BlurData>
        get() = _mockBlurList

}