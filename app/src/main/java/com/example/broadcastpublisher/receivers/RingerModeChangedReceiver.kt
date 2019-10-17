package com.example.broadcastpublisher.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import com.example.broadcastpublisher.messages.Mailman

class RingerModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var mode = "ERROR getting mode"
        when (intent?.getIntExtra(AudioManager.EXTRA_RINGER_MODE, 43)) {
            AudioManager.RINGER_MODE_NORMAL -> mode = "normal"
            AudioManager.RINGER_MODE_SILENT -> mode = "silent"
            AudioManager.RINGER_MODE_VIBRATE -> mode = "vibrate"
        }
        Mailman.send("Ringer mode changed to $mode")
    }
}