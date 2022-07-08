package com.bur.exampleweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bur.exampleweek1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityBtn.setOnClickListener {
            val intent = Intent(this, ActivityExampleActivity::class.java)
            startActivity(intent)
        }

        binding.fragmentBtn.setOnClickListener {
            val intent = Intent(this, FragmentExampleActivity::class.java)
            startActivity(intent)
        }

        binding.serviceBtn.setOnClickListener {
            val intent = Intent(this, ServiceExampleActivity::class.java)
            startActivity(intent)
        }

        binding.intentBtn.setOnClickListener {
            val intent = Intent(this, IntentExapleActivity::class.java)
            startActivity(intent)
        }

        binding.contentProviderBtn.setOnClickListener {
            val intent = Intent(this, ContentProviderExampleActivity::class.java)
            startActivity(intent)
        }

        binding.broadcastReciverBtn.setOnClickListener {
            val intent = Intent(this, BroadcastReciverExampleActivity::class.java)
            startActivity(intent)
        }
    }


}