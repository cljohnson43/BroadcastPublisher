package com.example.broadcastpublisher.uicontrollers

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.broadcastpublisher.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFrags()
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
