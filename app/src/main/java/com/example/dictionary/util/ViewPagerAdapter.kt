package com.example.dictionary.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class ViewPagerAdapter(
    manager: FragmentManager
) : FragmentPagerAdapter(
    manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? = fragmentTitleList[position]

    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment: Fragment,title: String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}