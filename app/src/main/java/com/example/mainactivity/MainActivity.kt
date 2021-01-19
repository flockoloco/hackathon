package com.example.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Bottom navigation
        val anvilFragment = AnvilFragment()
        val mineFragment = MineFragment()

        setCurrentFragment(anvilFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.AnvilFragment -> setCurrentFragment(anvilFragment)
                R.id.MineFragment -> setCurrentFragment(mineFragment)
            }
            true
        }

        //-=-=-=-=-=-=-=-=-=-=--=-=-=-=-==-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=



    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.hostFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

}