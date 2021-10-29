package com.diazp.bisadiaturandroid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.diazp.bisadiaturandroid.activity.MasukActivity
import com.diazp.bisadiaturandroid.fragment.AkunFragment
import com.diazp.bisadiaturandroid.fragment.HomeFragment
import com.diazp.bisadiaturandroid.fragment.KeranjangFragment
import com.diazp.bisadiaturandroid.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentAkun: Fragment = AkunFragment()
    private val fragmentKeranjang: Fragment = KeranjangFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var statusLogin = false

    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setBotNav()
    }

    fun setBotNav() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang)
            .commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.menuHome -> {
                    callFragment(0, fragmentHome)
                }
                R.id.menuAkun -> {
                    if (s.getStatusLogin()) {
                        callFragment(1, fragmentAkun)
                    } else {
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
                R.id.menuKeranjang -> {
                    callFragment(2, fragmentKeranjang)
                }
            }

            false
        }
    }

    fun callFragment(item: Int, fragment: Fragment) {
        menuItem = menu.getItem(item)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}