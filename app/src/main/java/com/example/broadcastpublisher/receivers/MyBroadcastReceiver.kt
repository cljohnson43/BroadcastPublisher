package com.example.broadcastpublisher.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.broadcastpublisher.messages.Mailman

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Mailman.send("Received custom broadcast!!!")
    }
}