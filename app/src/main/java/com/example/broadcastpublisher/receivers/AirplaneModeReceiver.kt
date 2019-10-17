package com.example.broadcastpublisher.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.broadcastpublisher.messages.Mailman

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Mailman.send(
            "Airplane mode has been turned ${if (intent?.getBooleanExtra(
                    "state",
                    false
                ) == true
            ) "on" else "off"}"
        )
    }
}