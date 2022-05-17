package com.example.observer

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyServer : LifecycleObserver{

    private val TAG = "MYHOMEWORK ACTIVITY"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun connection() {
        Log.i(TAG,"PROCESS CONNECTED")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disconnect(){
        Log.i(TAG,"PROCESS DISCONNECTED")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(source: LifecycleOwner?, event: Lifecycle.Event?) {
        Log.i(TAG, "On any() $source $event")
    }
}
