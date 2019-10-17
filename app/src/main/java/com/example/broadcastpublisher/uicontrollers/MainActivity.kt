package com.example.broadcastpublisher.uicontrollers

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.broadcastpublisher.R
import com.example.broadcastpublisher.receivers.*

class MainActivity : AppCompatActivity() {

    val airplaneMode: AirplaneModeReceiver by lazy { AirplaneModeReceiver() }
    val bluetoothDiscoveryStarted: BluetoothDiscoveryStartedReceiver by lazy {
        BluetoothDiscoveryStartedReceiver()
    }
    val bluetoothDiscoveryFinished: BluetoothDiscoveryFinishedReceiver by lazy {
        BluetoothDiscoveryFinishedReceiver()
    }
    val configurationChange: ConfigurationChangeReceiver by lazy {
        ConfigurationChangeReceiver()
    }
    val ringerMode: RingerModeChangedReceiver by lazy { RingerModeChangedReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFrags()

        registerReceivers()
    }

    override fun onDestroy() {
        super.onDestroy()

        unRegisterReceivers()
    }

    fun registerReceivers() {
        registerReceiver(airplaneMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(configurationChange, IntentFilter(Intent.ACTION_CONFIGURATION_CHANGED))
        registerReceiver(bluetoothDiscoveryStarted, IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED))
        registerReceiver(bluetoothDiscoveryFinished, IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED))
        //registerReceiver(ringerMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

    }

    fun unRegisterReceivers() {
        unregisterReceiver(airplaneMode)
        unregisterReceiver(configurationChange)
        unregisterReceiver(bluetoothDiscoveryFinished)
        unregisterReceiver(bluetoothDiscoveryStarted)
        //unregisterReceiver(ringerMode)
    }

    fun setupFrags() {
        val frag1 = Fragment1()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_fragment_1, frag1)
            commit()
        }

        val frag2 = Fragment2()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_fragment_2, frag2)
            commit()
        }

        val frag3 = Fragment3()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_fragment_3, frag3)
            commit()
        }
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_send_broadcast -> {
                sendBroadcast(Intent("${application.packageName}"), Manifest.permission.SEND_SMS)
            }
        }
    }
}
