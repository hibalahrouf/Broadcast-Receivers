package com.example.broadcastwatcherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {

            boolean airplaneEnabled = intent.getBooleanExtra("state", false);

            String info = airplaneEnabled
                    ? "Airplane mode is ON"
                    : "Airplane mode is OFF";

            Toast.makeText(context, info, Toast.LENGTH_LONG).show();
        }
    }
}