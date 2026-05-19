package com.example.broadcastwatcherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternalMessageReceiver extends BroadcastReceiver {

    public static final String CUSTOM_ACTION =
            "com.example.broadcastwatcherapp.INTERNAL_MESSAGE";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (CUSTOM_ACTION.equals(intent.getAction())) {

            String message = intent.getStringExtra("content");

            Toast.makeText(
                    context,
                    "Message received: " + message,
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}