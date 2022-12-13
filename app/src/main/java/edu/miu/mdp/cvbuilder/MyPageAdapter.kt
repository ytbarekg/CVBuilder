package edu.miu.mdp.cvbuilder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPageAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 4 // We have 4 fragments
    // Provide a new Fragment associated with the specified position.
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> WorkFragment()
            2 -> ContactFragment()
            3 -> AbountMeFragment()
            else -> Fragment()
        }
    }
}