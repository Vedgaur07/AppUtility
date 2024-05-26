package com.android.apputilitylibrary.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.android.apputilitylibrary.R;

public class StatusBarUtils {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void statusBarColor(Activity context, String color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(/*View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | */View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

    public static void setWhiteStatusAndBlackTxt(Activity activity) {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        activity.getWindow().getDecorView().setSystemUiVisibility(/*View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | */View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().setNavigationBarColor(ContextCompat.getColor(activity, android.R.color.white));
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, android.R.color.white));

    }

    public static void setLightStatusBar(Activity activity, String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            View view = window.getDecorView();
            int flags = view.getSystemUiVisibility();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.parseColor(color));
        }
    }

    public static void setTransparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  // View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#00000000"));
        }
    }

    public static void setTransparentStatusBar(Activity activity, String customStatusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  // View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(customStatusColor));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void setCustomStatusBar(Activity context, String bgColorName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.getDecorView().setSystemUiVisibility(0);  // View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(bgColorName));
        }
    }

    public static void SetStatusBarColor(Activity activity, String statusBarColor, StatusBarState state) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(statusBarColor));
            int newUiVisibility = (int) window.getDecorView().getSystemUiVisibility();

            if (state == StatusBarState.Light) {
                //Dark Text to show up on your light status bar
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    newUiVisibility |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
            } else if (state == StatusBarState.Dark) {
                //Light Text to show up on your dark status bar
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    newUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
            }
            window.getDecorView().setSystemUiVisibility(newUiVisibility);
        }
    }

    public enum StatusBarState {
        Light,
        Dark
    }

}
