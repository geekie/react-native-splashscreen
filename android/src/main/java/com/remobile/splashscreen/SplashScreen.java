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
                    // AlphaAnimation fadeOut = new AlphaAnimation(1, 0);
                    // fadeOut.setDuration(1000);
                    // View view = ((ViewGroup)splashDialog.getWindow().getDecorView()).getChildAt(0);
                    // view.startAnimation(fadeOut);
                    // fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    //     @Override
                    //     public void onAnimationEnd(Animation animation) {
                    //         splashDialog.dismiss();
                    //         splashDialog = null;
                    //     }
                    // });

                    splashDialog.dismiss();
                    splashDialog = null;
                }
            }
        });
    }
}
