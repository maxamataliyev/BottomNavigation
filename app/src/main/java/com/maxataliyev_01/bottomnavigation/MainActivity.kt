package com.maxataliyev_01.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.maxataliyev_01.bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()
        setCurrentFragment(firstFragment)

        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome->setCurrentFragment(firstFragment)
                R.id.miMessages->setCurrentFragment(secondFragment)
                R.id.miProfile->setCurrentFragment(thirdFragment)
            }
            true
        }
        binding.bottomNavigationMenu.getOrCreateBadge(R.id.miMessages).apply {
            number=10
            isVisible=true
        }

    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}