package com.research.keybypass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TermuxReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String cmd = intent.getStringExtra("key");
        if (cmd != null) {
            TermuxAccessibilityService.triggerAction(cmd);
        }
    }
}
