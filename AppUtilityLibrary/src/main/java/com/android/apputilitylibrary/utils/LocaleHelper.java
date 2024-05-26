package com.android.apputilitylibrary.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LocaleHelper {
    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    public static void onCreate(Context context) {

        String lang;
        if (getLanguage(context).isEmpty()) {
            lang = getPersistedData(context, Locale.getDefault().getLanguage());
        } else {
            lang = getLanguage(context);
        }

        setLocale(context, lang);
    }

    public static void onCreate(Context context, String defaultLanguage) {
        String lang = getPersistedData(context, defaultLanguage);
        setLocale(context, lang);
    }

    public static String getLanguage(Context context) {
        return getPersistedData(context, Locale.getDefault().getLanguage());
    }

    public static void setLocale(Context context, String language) {
        persist(context, language);
        updateResources(context, language);
    }

    /*
    *   Fetched Saved App Language in Preference
    *
    * */
    private static String getPersistedData(Context context, String defaultLanguage) {
        /*PreferenceManger sd = AppApplication.getPreferenceManger();
        return sd.getStringValue(SELECTED_LANGUAGE, defaultLanguage);*/
        return defaultLanguage;
    }

    /*
    *   Save Lnaguage in preference
    *
    * */
    private static void persist(Context context, String language) {
        /*PreferenceManger sd = AppApplication.getPreferenceManger();
        sd.putString(SELECTED_LANGUAGE, language);*/
    }

    private static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}