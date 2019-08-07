package com.remobile.splashscreen;

import android.app.Activity;
import android.app.Dialog;

public class SplashScreen {
    private static Dialog splashDialog;

    public static void show(final Activity activity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {
                    if (splashDialog == null) {
                        splashDialog = new Dialog(activity, R.style.SplashScreen_Theme);
                        splashDialog.setContentView(R.layout.splash);
                        splashDialog.setCancelable(false);
                    }

                    if (!splashDialog.isShowing()) {
                        splashDialog.show();
                    }
                }
            }
        });
    }

    public static void hide(final Activity activity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (splashDialog != null && splashDialog.isShowing()) {
                    splashDialog.dismiss();
                    splashDialog = null;
                }
            }
        });
    }
}
