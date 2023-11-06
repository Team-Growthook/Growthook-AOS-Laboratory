package com.growthook.growthooklaboratory.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.growthook.growthooklaboratory.R
import com.growthook.growthooklaboratory.databinding.ActivityMainBinding
import com.growthook.growthooklaboratory.util.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bnvHome.selectedItemId = R.id.menu_home
        supportFragmentManager.findFragmentById(R.id.fcv_home)
            ?: navigateTo<HomeFragment>()
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> navigateTo<HomeFragment>()
                R.id.menu_planlist -> navigateTo<PlanlistFragment>()
                R.id.menu_mypage -> navigateTo<MypageFragment>()
            }
            true
        }
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_home, T::class.simpleName)
        }
    }
}
