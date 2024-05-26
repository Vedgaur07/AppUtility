package com.android.apputilitylibrary.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

public class DisplayHelper {

    public static int[] getScreenSize(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if(windowManager!=null)
        {
            windowManager.getDefaultDisplay().getMetrics(displaymetrics);
            int h = displaymetrics.heightPixels;
            int w = displaymetrics.widthPixels;

            return new int[]{w, h};
        }
        return new int[]{0,0};
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradient(Activity activity, int drawableResId)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(drawableResId);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

    public static int getResourceDimenInPx(Context context, int resId)
    {
        return (int) (context.getResources().getDimension(resId) / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A int value to represent px equivalent to dp depending on device density
     */
    public static int convertDpToPx(Context context, float dp)
    {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A int value to represent dp equivalent to px value
     */
    public static int convertPxToDp(Context context, float px)
    {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) dp;
    }

    public static int convertPxToSp(final Context context, final float px)
    {
        return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static int convertSpToPx(final Context context, final float sp)
    {
        return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
    }

}
