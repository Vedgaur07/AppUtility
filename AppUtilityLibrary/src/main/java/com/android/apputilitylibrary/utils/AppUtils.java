package com.android.apputilitylibrary.utils;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.android.apputilitylibrary.R;

import java.util.List;

public class AppUtils {


    public static final String APP_LINK = "https://play.google.com/store/apps/details?id=";

    public static String getAppLink(String packageName) {
        return String.format("%s%s", APP_LINK, packageName);
    }

    public static void setFullScreenImage(Activity context) {
        context.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static boolean haveStoragePermission(Activity caller) {
        int permissionCheck = ContextCompat.checkSelfPermission(caller,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            permissionCheck = ContextCompat.checkSelfPermission(caller,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);

            return permissionCheck == PackageManager.PERMISSION_GRANTED;
        }

        return false;
    }

/*
    private static void shareDynamicUrlApp(Context context, String appName) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, appName);
            String shareMessage = "\nLet me recommend you this application\n\n";
//            shareMessage = /*shareMessage + * /"https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareMessage = /*shareMessage + * / DynamicLinksUtil.generateContentLink().toString();
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }
*/

    public static void shareAppWithFixMessage(Context context, String message, String appName) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, appName);
            String shareMessage = "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + message;
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    public static void shareAppWithMessage(Context context, String message, String appName) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, appName);
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    public static void shareDataOnAnotherApp(@NonNull Context context, String packageName, String shareData, String appName) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, appName);
        intent.putExtra(Intent.EXTRA_TEXT, shareData);
        intent.setPackage(packageName);
        boolean appFound = false;
        List<ResolveInfo> matches = context.getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith(packageName)) {
                intent.setPackage(info.activityInfo.packageName);
                appFound = true;
                break;
            }
        }
        if (appFound) {
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(context, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void copyTextToClipBoard(@NonNull Context context, String label, String textForCopy) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, textForCopy);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, "Copy to clipboard", Toast.LENGTH_SHORT).show();
    }

    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }

    public static <T> boolean isListEmpty(List<T> list) {
        return list == null || list.size() <= 0;
    }

    public static <T> boolean isModelEmpty(T model) {
        return model == null;
    }

    public static void getOpenFacebookIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id_here>"));
            context.startActivity(intent);
        } catch (Exception e) {
            Intent intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/<user_name_here>"));
            context.startActivity(intent);
        }
    }

    public static void getOpenYouTubeIntent(Context context) {
        String youtubeURL = "https://www.youtube.com/papelbd";
        Intent youtubeIntent=null;
        try {
            youtubeIntent=new Intent(Intent.ACTION_VIEW);
            youtubeIntent.setPackage("com.google.android.youtube");
            youtubeIntent.setData(Uri.parse(youtubeURL ));
            context.startActivity(youtubeIntent);
        } catch (ActivityNotFoundException e) {
            youtubeIntent= new Intent(Intent.ACTION_VIEW);
            youtubeIntent.setData(Uri.parse(youtubeURL ));
            context.startActivity(youtubeIntent);
        }
    }

    public static void getOpenTelegramIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=partsilicon"));
        context.startActivity(intent);
    }

    public static void getOpenInstagramIntent(Context context) {
        Uri uri = Uri.parse("http://instagram.com/_u/exam_form");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            context.startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/exam_form")));
        }
    }

    public static void setupCarousel(Context context, ViewPager2 viewPager, @DimenRes int nextItemVisiblePx, @DimenRes int currentItemHorizontalMarginPx){

        /*
        *
        *   <dimen name="viewpager_next_item_visible">26dp</dimen>
            <dimen name="viewpager_current_item_horizontal_margin">42dp</dimen>
        *
        * */

        viewPager.setOffscreenPageLimit(1);

        float mNextItemVisiblePx = context.getResources().getDimension(nextItemVisiblePx);
        float mCurrentItemHorizontalMarginPx = context.getResources().getDimension(currentItemHorizontalMarginPx);
        float pageTranslationX = mNextItemVisiblePx + mCurrentItemHorizontalMarginPx;
        viewPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setTranslationX(-pageTranslationX * position);
                page.setScaleY(1 - (0.25f * Math.abs(position)));
                page.setAlpha(0.25f + (1 - Math.abs(position)));
            }
        });
        HorizontalMarginItemDecoration itemDecoration = new HorizontalMarginItemDecoration(context, currentItemHorizontalMarginPx);
        viewPager.addItemDecoration(itemDecoration);
    }


}
