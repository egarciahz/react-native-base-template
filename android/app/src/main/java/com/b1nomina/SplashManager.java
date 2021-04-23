package com.b1nomina;

import android.app.Activity;
import android.app.Dialog;

import java.lang.ref.WeakReference;

public class SplashManager {
  private static WeakReference<Activity> splashActivity;
  private static Dialog msDialog;

  public static void show(final Activity activity) {
    if(activity == null) return;
    splashActivity = new WeakReference<Activity>(activity);
    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if(!activity.isFinishing()) {
          msDialog = new Dialog(activity, R.style.AppTheme);
          msDialog.setContentView(R.layout.launch_screen);
          msDialog.setCancelable(false);

          if(!msDialog.isShowing()) {
            msDialog.show();
          }
        }
      }
    });
  }

  public static void hide() {
    final Activity activity = splashActivity.get();
    if(activity == null) {
      return;
    }

    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {

        if(!activity.isFinishing() && !activity.isDestroyed()) {
          if(msDialog!=null && msDialog.isShowing()) {
              msDialog.dismiss();
              msDialog = null;
          }
        }
      }
    });
  }
}
