package com.retroarch.browser.retroactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class SecondaryRetroActivity extends Activity {
    public static final String ACTION_FINISH_SECONDARYACTIVITY = "com.lge.swivel.intent.action.secondary.finish";

    private TextView textView;

    /** A {@link BroadcastReceiver} to receive action for finish from MainActivity. */
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg, Intent intent) {
            String action = intent.getAction();
            if (ACTION_FINISH_SECONDARYACTIVITY.equals(action)) {
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // The most simple layout is no layout at all
        textView = new TextView(this);
        setContentView(textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mBroadcastReceiver, new IntentFilter(ACTION_FINISH_SECONDARYACTIVITY));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mBroadcastReceiver);
    }
}
