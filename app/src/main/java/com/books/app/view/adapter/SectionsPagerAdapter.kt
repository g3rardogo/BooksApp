package com.books.app.view.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.books.app.R
import com.books.app.view.ui.fragments.BooksFragment

private val TAB_TITLES = arrayOf("seccion 1")

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = BooksFragment()
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Seccion 1"
            1 -> return "Seccion 2"
            2 -> return "Seccion 3"
            3 -> return "Seccion 4"
        }
        return null
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 1
    }
}