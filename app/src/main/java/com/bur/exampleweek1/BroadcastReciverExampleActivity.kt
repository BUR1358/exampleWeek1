package com.bur.exampleweek1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bur.exampleweek1.databinding.ActivityBroadcastReciverExampleBinding


class BroadcastReciverExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityBroadcastReciverExampleBinding
    lateinit var wifiSwitch: Switch
    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastReciverExampleBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_broadcast_reciver_example)
        setContentView(binding.root)

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiSwitch = binding.wifiSwitch
        binding.wifiSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val settingsIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                    startActivity(settingsIntent)
                } else {
                    wifiManager.isWifiEnabled = true
                }
                wifiSwichChecker()

            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val settingsIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                    startActivity(settingsIntent)
                } else {
                    wifiManager.isWifiEnabled = false
                }
                wifiSwichChecker()
            }
        }
    }

    private fun wifiSwichChecker() {
        if (wifiManager.isWifiEnabled) {
            wifiSwitch.isChecked = true
            wifiSwitch.text = getString(R.string.wifiOn)
        } else {
            wifiSwitch.isChecked = false
            wifiSwitch.text = getString(R.string.wifiOff)
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }

    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.getIntExtra(
                WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN
            )) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    wifiSwichChecker()
                    Toast.makeText(applicationContext, "Wifi включен", Toast.LENGTH_SHORT).show()
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    wifiSwichChecker()
                    Toast.makeText(applicationContext, "Wifi выключен", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}