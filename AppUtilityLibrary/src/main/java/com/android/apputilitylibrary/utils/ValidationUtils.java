package com.android.apputilitylibrary.utils;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    public static boolean validateEmail(String emailStr) {
        return !TextUtils.isEmpty(emailStr) && Patterns.EMAIL_ADDRESS.matcher(emailStr).matches();
    }

    public static boolean isValidMobile(String phone) {
        String expression = "^([0-9\\+]|\\(\\d{1,9}\\))[0-9\\-\\. ]{9,11}$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidUrl(String url) {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url.toLowerCase());
        return m.matches();
    }

    public static boolean isValidID(CharSequence target) {
        return Patterns.PHONE.matcher(target).matches();
    }

    public static String getSecureEmail(String email) {
        String[] emailSepAtTheRate = email.split("@");
        List<String> valSS = new ArrayList<>();
        String finalEmail = "";
        if (emailSepAtTheRate.length > 0) {
            int emailLength = emailSepAtTheRate[0].length();
            int half = emailLength / 2;
            half = half > 5 ? 4 : half;
            String ss = emailSepAtTheRate[0].substring(half);
            if (ss.length() > 2) {
//                for (int i = 0; i < (ss.length() - 2); i++) {
//                    valSS.add(String.valueOf(ss.charAt(i)).replace(String.valueOf(ss.charAt(i)), "*"));
//                }
                for (int i = 0; i < 3; i++) {
                    valSS.add("*");
                }
                valSS.add(String.valueOf(ss.charAt(ss.length() - 2)));
                valSS.add(String.valueOf(ss.charAt(ss.length() - 1)));
            } else {
                valSS.add(ss);
            }
            String firstStr = "";
            if (emailSepAtTheRate[0].length() > 3) {
                firstStr = emailSepAtTheRate[0].substring(0, 4);
            } else {
                firstStr = emailSepAtTheRate[0];
            }
            String secStr = TextUtils.join("", valSS);
            List<String> lastStr = new ArrayList<>();
            String thirdStr = "";
            if (emailSepAtTheRate[1].length() > 6) {
                lastStr.add(String.valueOf(emailSepAtTheRate[1].charAt(0)));
                half = emailSepAtTheRate[1].length() / 2;
                ss = emailSepAtTheRate[1].substring(1, half-1);
//                for (int i = 0; i < ss.length(); i++) {
//                    lastStr.add(String.valueOf(ss.charAt(i)).replace(String.valueOf(ss.charAt(i)), "*"));
//                }
                for (int i = 0; i < 2; i++) {
                    lastStr.add("*");
                }
                thirdStr = String.format("@%s%s",TextUtils.join("", lastStr), emailSepAtTheRate[1].substring(half-1));
            } else {
                thirdStr = "@" + emailSepAtTheRate[1];
            }
            finalEmail = String.format("%s%s%s", firstStr, secStr, thirdStr);
        }
        return finalEmail;
    }

}