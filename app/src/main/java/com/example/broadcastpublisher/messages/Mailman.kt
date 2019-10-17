package com.example.broadcastpublisher.messages

import org.greenrobot.eventbus.EventBus

object Mailman{
    fun send(msg: String) {
        val message1 = FragmentOneMessage(msg)
        EventBus.getDefault().post(message1)

        val message2 = FragmentTwoMessage(msg)
        EventBus.getDefault().post(message2)

        val message3 = FragmentThreeMessage(msg)
        EventBus.getDefault().post(message3)
    }

}