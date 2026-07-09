package com.research.keybypass;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class TermuxAccessibilityService extends AccessibilityService {
    private static TermuxAccessibilityService instance;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
    }

    public static void triggerAction(String action) {
        if (instance == null) return;
        if ("enter".equalsIgnoreCase(action) || "send".equalsIgnoreCase(action)) {
            instance.performGlobalAction(GLOBAL_ACTION_NOTIFICATIONS); 
        } else if ("back".equalsIgnoreCase(action)) {
            instance.performGlobalAction(GLOBAL_ACTION_BACK);
        }
    }

    @Override public void onAccessibilityEvent(AccessibilityEvent event) {}
    @Override public void onInterrupt() {}
}
