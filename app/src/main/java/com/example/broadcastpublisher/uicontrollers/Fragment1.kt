package com.example.broadcastpublisher.uicontrollers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.broadcastpublisher.R
import kotlinx.android.synthetic.main.fragment_one.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import com.example.broadcastpublisher.messages.FragmentOneMessage

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()

        unSubscribe()
    }

    fun subscribe() {
        EventBus.getDefault().register(this)
    }

    fun unSubscribe() {
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onMessageReceived(message: FragmentOneMessage) {
        tv_label.text = "Message Received: ${message.msg}"
    }
}