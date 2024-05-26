package com.android.apputilitylibrary.utils;

import android.os.Build;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.text.HtmlCompat;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    public static boolean isNumberExist(String value) {
        Pattern numberPat = Pattern.compile("\\d+");
        Matcher matcher = numberPat.matcher(value);
        return matcher.find();
    }

    public static void setTextMaxLength(EditText editText, int maxLength) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public static boolean isEmailIdValid(String target) {
        return !isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean hasValidText(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return !isEmpty(textView.getText().toString().trim());
        }
        return false;
    }

    public static boolean isEquals(String str1, String str2) {
        if (!isEmpty(str1) && !isEmpty(str2)){
            return str1.equals(str2);
        }
        return false;
    }

    public static boolean isEmpty(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return isEmpty(textView.getText().toString().trim());
        }
        return true;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static boolean isCheckNullAndEmpty(String value) {
        return value == null && isEmpty(value);
    }

    public static int getLength(TextView textView) {
        return getText(textView).length();
    }

    public static int getLength(EditText editText) {
        return getText(editText).length();
    }

    public static String getText(TextView textView) {
        if (textView != null && textView.getText() != null) {
            return textView.getText().toString().trim();
        }
        return "";
    }


    public static boolean checkValidAddress(String address) {
        return !isEmpty(address) &&
                !address.equalsIgnoreCase("Unnamed Location") &&
                !address.equalsIgnoreCase("Null");
    }


    public static String priceFormat(String price) {
        String newPrice = String.format(Locale.getDefault(), "%.2f", Double.parseDouble(price));
        String formatPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(Double.parseDouble(newPrice));

        try {
            if (!formatPrice.contains(".")) {
                formatPrice = formatPrice + ".00";
            }
        } catch (Exception e) {
            Log.e("PRICE FORMAT EXCEPTION", e.getMessage());
        }

        return String.format("%s", formatPrice);
    }

    public static String getText(EditText editText) {
        if (editText != null && editText.getText() != null) {
            return editText.getText().toString().trim();
        }
        return "";
    }

    public static void showHTMLText(TextView textView, String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(value, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(value));
        }
    }

    public static Spanned getHTMLText(String value) {
        return HtmlCompat.fromHtml(getString(value), HtmlCompat.FROM_HTML_MODE_COMPACT);
    }

    public static void setPrice(TextView amountLabel, String rsFormat, String amount, View... views) {
        int i = amount == null ? 0 : Integer.valueOf(amount);
        setPrice(amountLabel, rsFormat, i, views);
    }

    public static void setPrice(TextView amountLabel, String rsFormat, int amount, View... views) {
        if (amount > 0) {
            amountLabel.setVisibility(View.VISIBLE);
            amountLabel.setText(String.format(rsFormat, TextUtils.priceFormat(String.valueOf(amount))));
            for (View view : views) {
                view.setVisibility(View.VISIBLE);
            }
        } else {
            amountLabel.setVisibility(View.GONE);
            for (View view : views) {
                view.setVisibility(View.GONE);
            }
        }
    }

    public static boolean isStringNotEmpty(String value) {
        return value != null && !TextUtils.isEmpty(value);
    }

    public static String getString(String str) {
        if (str != null && !isEmpty(str)) {
            return str;
        }
        return "";
    }

    public static int getIntFromString(String str) {
        if (str != null && !isEmpty(str)) {
            return isInteger(str) ? Integer.parseInt(str) : 0;
        }
        return 0;
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(isEmpty(s)) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public static boolean isStringMatch(TextView textView, String val) {
        return getText(textView).equalsIgnoreCase(val);
    }

    public static boolean isStringMatch(EditText editText, String val) {
        return getText(editText).equalsIgnoreCase(val);
    }

}