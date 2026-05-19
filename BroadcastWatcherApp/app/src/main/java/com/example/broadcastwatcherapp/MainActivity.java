package com.example.broadcastwatcherapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private NetworkModeReceiver networkModeReceiver;
    private boolean receiverEnabled = false;

    private TextView textReceiverStatus;
    private Button buttonToggleReceiver, buttonSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkModeReceiver = new NetworkModeReceiver();

        textReceiverStatus = findViewById(R.id.textReceiverStatus);
        buttonToggleReceiver = findViewById(R.id.buttonToggleReceiver);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);

        buttonToggleReceiver.setOnClickListener(v -> toggleNetworkReceiver());
        buttonSendMessage.setOnClickListener(v -> sendInternalBroadcast());
    }

    private void toggleNetworkReceiver() {
        if (!receiverEnabled) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                registerReceiver(networkModeReceiver, filter, RECEIVER_NOT_EXPORTED);
            } else {
                registerReceiver(networkModeReceiver, filter);
            }

            receiverEnabled = true;
            textReceiverStatus.setText("Airplane receiver enabled");
            buttonToggleReceiver.setText("Disable Airplane Receiver");

        } else {
            unregisterReceiver(networkModeReceiver);

            receiverEnabled = false;
            textReceiverStatus.setText("Airplane receiver disabled");
            buttonToggleReceiver.setText("Enable Airplane Receiver");
        }
    }

    private void sendInternalBroadcast() {
        Intent intent = new Intent(InternalMessageReceiver.CUSTOM_ACTION);
        intent.setPackage(getPackageName());
        intent.putExtra("content", "Hello from BroadcastWatcherApp");

        sendBroadcast(intent);

        Toast.makeText(
                this,
                "Internal broadcast sent",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    protected void onDestroy() {
        if (receiverEnabled) {
            unregisterReceiver(networkModeReceiver);
        }

        super.onDestroy();
    }
}