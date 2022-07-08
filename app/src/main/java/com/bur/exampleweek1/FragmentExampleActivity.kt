package com.bur.exampleweek1

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bur.exampleweek1.databinding.ActivityFragmentExampleBinding


class FragmentExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFragmentExampleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.fragmentExampleBtn.setOnClickListener {
            val exampleFragment = ExampleFragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(ExampleFragment::class.java.simpleName)
            if (fragment !is ExampleFragment) {
                supportFragmentManager.beginTransaction()
                    .add(binding.FragmentConteiner.id, exampleFragment, ExampleFragment::class.java.simpleName).addToBackStack(null).commit()
            }
        }
    }
}