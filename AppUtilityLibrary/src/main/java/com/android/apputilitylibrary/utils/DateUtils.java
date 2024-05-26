package com.android.apputilitylibrary.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SERVER_ONLY_DATE_FORMAT = "dd-MM-yyyy";
    public static final String SIMPLE_DATE_FORMAT_WITH_TIME = "dd/MM/yyyy HH:mm:ss";
    public static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy";
    public static final String FORECAST_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DD_MMMM_YYYY = "dd MMMM, yyyy";
    public static final String FORECAST_DATE_FORMAT_TIME_12 = "yyyy-MM-dd HH:mm aa";
    public static final String FORECAST_DATE_FORMAT_TIME_24 = "yyyy-MM-dd hh:mm:ss";
    public static final String DOB_DATE_FORMAT = "dd MMM, yyyy";
    public static final String DOB_DATE_FORMAT_WITH_TIME = "dd MMM, yyyy HH:mm:ss";
    public static final String TIME_PICKED_FORMAT = "EEE MMM dd HH:mm:ss Z yyyy";
    public static final String TIME_FORMAT = "hh:mm a";
    public static final String TRANSACTION_FORMAT = "dd MMM yyyy, hh:mm aa";
    public static final String CHAT_HISTORY_DATE_FORMAT = "hh:mmaa dd-MMM-yy";
    public static final String ORDER_DATE_FORMAT = "dd, MMM yyyy";
    public static final String PERFORMANCE_MONTH_FORMAT = "MMM";
    public static final String COMMENTS_DATE_FORMAT = "dd-MM-yy hh:mm aa";
    public static final String ORDER_DETAIL_DATE_FORMAT = "dd-MMM-yy hh:mm aa";
    public static final String ATTENDANCE_FORMAT = "dd MMM";
    public static final String ORDER_DATE_FORMATTED = "EEE, MMM dd, yyyy";
    public static final String MMM_DD_YYYY = "MMM dd, yyyy";

    public static final String CHAT_DISPLAY_TIME_FORMAT = "hh:mm a";
    public static final String CHAT_COPY_DATE_FORMAT = "[dd/mm, hh:mm aa]";
    public static final String POST_STATS_HOUR_FORMAT = "HH";

    public static final String DISH_DATE_TIME = "yyyy-MM-dd HH:mm";

    public static final String ORDER_TIME = "HH:mm";

    public static final String NUMBER_DATE_FORMAT = "dd";
    public static final String DAY_DATE_FORMAT = "EEEE";
    public static final String MONTH_DATE_FORMAT = "MMM";

    public static final String START_DATE_RANGE = "yyyy-MM-dd 00:00:00";
    public static final String END_DATE_RANGE = "yyyy-MM-dd 23:59:59";
    public static String SERVER_TIMEZONE_FORMAT =  "yyyy-MM-dd'T'HH:mm:ss";

    public static final String SINGLE_CHAT_DATE_FORMAT = "dd MMM yyyy";
    public static final String CHAT_HISTORY_ROW_DATE_FORMAT = "hh:mm aa dd/MM/yy";
    public static final String CONVERSATION_HEADER_DATE_FORMAT = "dd MMMM yyyy";
    public static final String CHAT_DISPLAY_DATE_FORMAT = "hh:mm a";
    public static final String UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String CREATED_AT = "yyyy-MM-dd'T'HH:mm:ss.000000Z";


    // "2020-05-14T09:36:10.000000Z"

    public static long secondsInMilli = 1000;
    public static long minutesInMilli = secondsInMilli * 60;
    public static long hoursInMilli = minutesInMilli * 60;
    public static long daysInMilli = hoursInMilli * 24;

    public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    public final static long MILLIS_PER_WEEK = (24 * 60 * 60 * 1000L) * 7;

    public static final String ORDER_HISTORY_DATE_FORMAT = "MMMM dd,yyyy";
    public static final String MONTH_DATE_YEAR = "MMM dd,yyyy";
    public static final String MONTH_DATE_YEAR_TIME = "MMM dd,yyyy - hh:mm a";

    /**
     * Return date in specified format.
     *
     * @param dateFormat   Date format
     * @return String representing date in specified format
     */
    public static String getDate(Date date, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        return formatter.format(date.getTime());
    }

    /**
     * Return date in specified format.
     *
     * @param milliSeconds Date in milliseconds
     * @param dateFormat   Date format
     * @return String representing date in specified format
     */
    public static String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = new Date(milliSeconds);
        return formatter.format(date.getTime());
    }

    public static String giveDate(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public static Date getDateFromStringDate(String dateToConvert, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = null;
        try {
            date = formatter.parse(dateToConvert);
        } catch (Exception ignored) {
            ignored.getLocalizedMessage();
        }
        return date;
    }

    public static String convertTime_12_To_24_FORMAT(String input, String oldFormat, String newFormat) {
        DateFormat df = new SimpleDateFormat(oldFormat);
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat(newFormat);
        Date date = null;
        String output = null;
        try{
            //Converting the input String to Date
            date= df.parse(input);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            //Displaying the date
            System.out.println(output);
        }catch(ParseException pe){
            pe.printStackTrace();
        }
        return output;
    }

    public static Date getLocalDate(String dateToConvert, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = formatter.parse(dateToConvert);
        } catch (Exception ignored) {

        }
        return date;
    }

    public static Date getEstimatedDate(Date date, int addTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, addTime);
        return cal.getTime();
    }

    /**
     * Return date in specified format.
     *
     * @param dateToConvert    Date in string
     * @param inputDateFormat  Input Date format
     * @param outputDateFormat Output Date format
     * @return String representing date in specified format
     */
    public static String parseStringDate(String dateToConvert, String inputDateFormat, String outputDateFormat) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat, Locale.getDefault());
        try {
            Date date = inputFormat.parse(dateToConvert);
            return outputFormat.format(date);
        } catch (ParseException | NullPointerException e) {
            // e.printStackTrace();
            return dateToConvert == null ? "" : dateToConvert;
        }
    }

    public static Date getCurrentDate(){
        return new Date(System.currentTimeMillis());
    }


    public static String getCurrentDate(String outputDateFormat) {

        try {
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat, Locale.getDefault());
            Date currentDate = new Date(System.currentTimeMillis());

            return outputFormat.format(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getPhilippinesCurrentDate(String outputDateFormat) {

        try {
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat, Locale.getDefault());
//            outputFormat.setTimeZone(TimeZone.getTimeZone("PHST"));
            Date currentDate = new Date(System.currentTimeMillis());

            return outputFormat.format(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static long getTimeInMillis(String date, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat, Locale.getDefault());

        try {
            //Convert to Date
            Date startDate = df.parse(date);
            Calendar c1 = Calendar.getInstance();
            //Change to Calendar Date
            c1.setTime(startDate);
            return c1.getTimeInMillis();

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static String dateDifference(String today, String lastDate) {

        long diff = 0;

        try {
            //get Time in milli seconds
            long ms1 = getTimeInMillis(today, "yyyyMMdd");
            long ms2 = getTimeInMillis(lastDate, "yyyyMMdd");
            //get difference in milli seconds
            diff = ms2 - ms1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Find number of days by dividing the mili seconds
        int diffInDays = (int) (diff / (24 * 60 * 60 * 1000));
        //System.out.println("Number of days difference is: " + diffInDays);

        return "" + diffInDays;
        //To get number of seconds diff/1000
        //To get number of minutes diff/(1000 * 60)
        //To get number of hours diff/(1000 * 60 * 60)

    }

    public static String parseDate(String parseDate,String inputPattern,String outputPattern) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(parseDate);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String getDateAndTime(Long timestamp, String dateFormat) {
        Date date = new Date(timestamp);
        SimpleDateFormat fullDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        return fullDateFormat.format(date);
    }

    public static String convertDateForChatDisplay(Date dateToConvert, String toDateFormat) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(toDateFormat, Locale.getDefault());
        return outputFormat.format(dateToConvert);
    }


    public static String convertDateFormat(Date dateToConvert, String toDateFormat) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(toDateFormat, Locale.getDefault());
        return outputFormat.format(dateToConvert);
    }

    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    public static long getDateDifference(String startDate, String endDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());

        try {
            Date getStartDate = simpleDateFormat.parse(startDate);
            Date getEndDate = simpleDateFormat.parse(endDate);

            //milliseconds
            long dateDifference = getEndDate.getTime() - getStartDate.getTime();

            System.out.println("startDate : " + startDate);
            System.out.println("endDate : " + endDate);
            System.out.println("dateDifference : " + dateDifference);


            long elapsedDays = dateDifference / daysInMilli;
            // dateDifference = dateDifference % daysInMilli;

            long elapsedHours = dateDifference / hoursInMilli;
            //  dateDifference = dateDifference % hoursInMilli;

            long elapsedMinutes = dateDifference / minutesInMilli;
            //  dateDifference = dateDifference % minutesInMilli;

            long elapsedSeconds = dateDifference / secondsInMilli;

            System.out.printf(
                    "%d days, %d hours, %d minutes, %d seconds%n",
                    elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
            return dateDifference;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;

    }

    public static String changeFormatOfDate(String dateStr, String oldFormat, String newFormat){
        try {
            DateFormat srcDf = new SimpleDateFormat(oldFormat);

            // parse the date string into Date object
            Date date = srcDf.parse(dateStr);

            DateFormat destDf = new SimpleDateFormat(newFormat);

            // format the date into another format
            dateStr = destDf.format(date);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String parseTimeFromStartTime(String startTime,String timeFormat){
        String getTimeDif = "";
        try
        {
            SimpleDateFormat format = new SimpleDateFormat(timeFormat);
            Date past = format.parse(startTime);
            Date now = new Date();

            Calendar startCalendar = new GregorianCalendar();
            startCalendar.setTime(past);
            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(now);

            long seconds= TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days=TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

            if(seconds<60) {
                System.out.println(seconds+" seconds ago");
                getTimeDif = "Just Now";
            } else if(minutes<60) {
                System.out.println(minutes+" minutes ago");
                getTimeDif = minutes+" minutes ago";
            } else if(hours<24) {
                System.out.println(hours+" hours ago");
                getTimeDif = hours+" hours ago";
            } else if(days<=31) {
                System.out.println(days+" days ago");
                getTimeDif = days+" days ago";
            } else if(diffMonth<=12){
                System.out.println(diffMonth+" months ago");
                getTimeDif = diffMonth+" months ago";
            } else {
                System.out.println(diffYear+" year ago");
                getTimeDif = diffYear+" year ago";
            }
        }
        catch (Exception j){
            j.printStackTrace();
        }
        return getTimeDif;
    }

    public static String getCurrentDateCompare(String startTime){
        String getTimeDif = "";
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date past = format.parse(startTime);
            Date now = new Date();
            long seconds= TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days=TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            if(minutes<60) {
                getTimeDif = String.valueOf(minutes);
            } else if(hours<24) {
                getTimeDif = String.valueOf(hours)+":"+minutes;
            } else {
                getTimeDif = String.valueOf(days)+":"+hours+":"+minutes;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTimeDif;
    }

    public static boolean isYesterday(String date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        try {
            Date d = simpleDateFormat.parse(date);
            return android.text.format.DateUtils.isToday(d.getTime() + android.text.format.DateUtils.DAY_IN_MILLIS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isTomorrow(String date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());
        try {
            Date d = simpleDateFormat.parse(date);
            return android.text.format.DateUtils.isToday(d.getTime() - android.text.format.DateUtils.DAY_IN_MILLIS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isToday(String date_time) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(date_time);
            System.out.println("Today is " + date.getTime());
            return android.text.format.DateUtils.isToday(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isToday(String date_time, String dateFormat) {
        DateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = null;
        try {
            date = (Date) formatter.parse(date_time);
            System.out.println("Today is " + date.getTime());
            return android.text.format.DateUtils.isToday(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean areSameDate(String d1, String d2, String dateFormat) {
        try {
            Date date1 =getDateFromStringDate(d1, dateFormat);
            Date date2 = getDateFromStringDate(d2, dateFormat);

            /*return date1.getDate() == date2.getDate() &&
                    date1.getMonth() == date2.getMonth() &&
                    date1.getYear() == date2.getYear();*/

            return date1.equals(date2);
        } catch (Exception e) {
            return false;
        }
    }

    public static Long getDateDifferenceInDays(Date startDate, Date endDate) {
        //milliseconds
        Long different = endDate.getTime() - startDate.getTime();

        Long secondsInMilli = 1000L;
        Long minutesInMilli = secondsInMilli * 60;
        Long hoursInMilli = minutesInMilli * 60;
        Long daysInMilli = hoursInMilli * 24;

        Long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        Long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        Long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        Long elapsedSeconds = different / secondsInMilli;

        System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

        return elapsedDays;
    }

    public static Date getDateFromMilliseconds(Long milliSeconds) {
        // Create a DateFormatter object for displaying date in specified format.
        Date date = new Date(milliSeconds);
        return date;
    }

    public static List<String> getMonthList(int limit) {
        List<String> monthsList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -i);
            monthsList.add(getMonthName(calendar.get(Calendar.MONTH)));
        }
        return monthsList;
    }

    public static String getMonthName(int monthPosition) {
        switch (monthPosition) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "Jul";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return "Jan";
        }
    }


    public static int getMonthNumber(String monthName) {
        switch (monthName) {
            case "Jan":
                return 0;
            case "Feb":
                return 1;
            case "Mar":
                return 2;
            case "Apr":
                return 3;
            case "May":
                return 4;
            case "Jun":
                return 5;
            case "Jul":
                return 6;
            case "Aug":
                return 7;
            case "Sep":
                return 8;
            case "Oct":
                return 9;
            case "Nov":
                return 10;
            case "Dec":
                return 11;
            default:
                return 0;
        }
    }

    public static boolean isDateBetweenCurrentDate(final Date start, final Date end, final Date date) {

        try {
            Date min = start;
            Date max = end;

            if (min.after(max)) {
                min = end;
                max = start;
            } else if (max.after(min)) {
                min = start;
                max = end;
            } else if (min.compareTo(max) == 0) {
                min = start;
                max = end;
            }
            return !(date.before(min) || date.after(max));
        }catch (Exception e){
            return true;
        }
    }

    public static int getKeyOfDateStatusIsCurrentBeforeAfter(final Date start, final Date end, final Date date) {
        int val = -1;
        try {
            Date min = start;
            Date max = end;

            if (min.after(max)) {
                min = end;
                max = start;
            } else if (max.after(min)) {
                min = start;
                max = end;
            } else if (min.compareTo(max) == 0) {
                min = start;
                max = end;
            }
            if (!(date.before(min) || date.after(max))) {
                val = 1;
            } else {
                if ((date.before(min))) {
                    val = 2;
                }
                if (date.after(max)) {
                    val = 0;
                }
            }
            return val;
        }catch (Exception e){
            return val;
        }
    }

    public static Date getLastWeekDateFromCurDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        return calendar.getTime();
    }

    public static Date getNextWeekDateFromCurDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        return calendar.getTime();
    }

    public static String getLastMonthDateFromCurDate(String dateFormat){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static String getNextMonthDateFromCurDate(String dateFormat){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, +1);
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static String getDayAndDate(String format, String date, String applyFormat) throws ParseException {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date myDate = sdf.parse(date);
        sdf.applyPattern(applyFormat);
        return sdf.format(myDate);
    }

    public static List<Date> getDishDates(String dateString1, String dateString2, String dateFormat) {
        ArrayList<Date> dates = new ArrayList<Date>();
        DateFormat df1 = new SimpleDateFormat(dateFormat);

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1 .parse(dateString1);
            date2 = df1 .parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 == null || date2 == null){
            return null;
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while(!cal1.after(cal2))
        {
            dates.add(cal1.getTime());
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public static List<String> getDates(String dateString1, String dateString2, String dateFormat) {
        ArrayList<String> dates = new ArrayList<String>();
        DateFormat df1 = new SimpleDateFormat(dateFormat);

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1 .parse(dateString1);
            date2 = df1 .parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 == null || date2 == null){
            return null;
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while(!cal1.after(cal2))
        {
            dates.add(String.valueOf(cal1.getTime()));
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }


    public static List<String> getDishTimes(String startTime, String endTime) {
        ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<String> times = new ArrayList<>();
        DateFormat df1 = new SimpleDateFormat("HH:mm");

        Date date1 = null;
        Date date2 = null;



        try {
            date1 = df1 .parse(startTime);
            date2 = df1 .parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 == null || date2 == null){
            return null;
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while(!cal1.after(cal2)) {

            String startDate = convertDateFormat(cal1.getTime(), TIME_FORMAT);
            dates.add(cal1.getTime());
            cal1.add(Calendar.HOUR, 1);
            String endDate = convertDateForChatDisplay(cal1.getTime(), TIME_FORMAT);

            times.add(startDate + " - " + endDate);

        }
        return times;
    }

    public static  boolean isDishAvailable(String startTime , String endTime){
        try {
            Date start = getDateFromStringDate(startTime,DISH_DATE_TIME);
            Date end = getDateFromStringDate(endTime,DISH_DATE_TIME);
            Date current = getDateFromStringDate(getCurrentDate(DISH_DATE_TIME),DISH_DATE_TIME);
            return isDateBetweenCurrentDate(start,end,current);
        }catch (Exception e){
            return true;
        }

    }

    public static long isCancelOrderAvailable(String dateTime){
        Date start = getDateFromStringDate(dateTime,DISH_DATE_TIME);
        Date current = getDateFromStringDate(getCurrentDate(DISH_DATE_TIME),DISH_DATE_TIME);
        return TimeUnit.MILLISECONDS.toMinutes(current.getTime() - start.getTime());
    }


    private static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    public static String getCurrentDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        return dayOfTheWeek.toLowerCase();
    }
    public static Date getStartDate(String dateTime){
        return getDateFromStringDate(parseStringDate(dateTime,ORDER_HISTORY_DATE_FORMAT,START_DATE_RANGE),START_DATE_RANGE);
    }

    public static Date getEndDate(String dateTime){
        return getDateFromStringDate(parseStringDate(dateTime,ORDER_HISTORY_DATE_FORMAT,END_DATE_RANGE),END_DATE_RANGE);
    }


    public static Date getAddDishStartDate(String dateTime){
        return getDateFromStringDate(parseStringDate(dateTime,DOB_DATE_FORMAT,START_DATE_RANGE),START_DATE_RANGE);
    }

    public static Date getAddDishEndDate(String dateTime){
        return getDateFromStringDate(parseStringDate(dateTime,DOB_DATE_FORMAT,END_DATE_RANGE),END_DATE_RANGE);
    }

    public static Date getOrderDate(String dateTime){
        return getDateFromStringDate(dateTime,SERVER_DATE_FORMAT);
    }

    public static boolean isDateInRange(final Date min, final Date max, final Date date){
        //return !(date.before(min) || date.after(max));
        // return date.after(min) && date.before(max);
        //return min.compareTo(date) * max.compareTo(date) >= 0;
        return date.compareTo(min) >= 0 && date.compareTo(max) <= 0;
    }

    public static String getTimeWithAddMinute(int minuteForAdd, String givenTime){
        SimpleDateFormat df = new SimpleDateFormat(SERVER_DATE_FORMAT);
        Date d = null;
        try {
            d = df.parse(givenTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        assert d != null;
        cal.setTime(d);
        cal.add(Calendar.MINUTE, minuteForAdd);
        return df.format(cal.getTime());
    }

    public static String convertUtcToLocalTime(String dateStr, String dateFormat){
        SimpleDateFormat df = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df.setTimeZone(TimeZone.getDefault());
        return df.format(date);
    }


    public static boolean compareTime(String inputFormat,String time1, String time2){
        Date clTime1 = new Date();
        Date clTime2 = new Date();

        SimpleDateFormat timeParser = new SimpleDateFormat("HH:mm", Locale.US);
        try {
            clTime1 = timeParser.parse(time1);
            clTime2 = timeParser.parse(time2);
        } catch (ParseException e) {
        }

        Calendar now = Calendar.getInstance();

        Date curTime = getCurrentDate();

        clTime1.setYear(now.get(Calendar.YEAR) - 1900);
        clTime1.setMonth(now.get(Calendar.MONTH));
        clTime1.setDate(now.get(Calendar.DAY_OF_MONTH));

        clTime2.setYear(now.get(Calendar.YEAR) - 1900);
        clTime2.setMonth(now.get(Calendar.MONTH));
        clTime2.setDate(now.get(Calendar.DAY_OF_MONTH));

        System.out.println(clTime1.toString());
        System.out.println(clTime2.toString());

        return curTime.after(clTime1) && curTime.after(clTime2);
    }

    private static Date parseDate(String date,SimpleDateFormat inputParser) {
        try {
            return inputParser.parse(date);
        } catch (ParseException e) {
            return new Date(0);
        }
    }

    /**
     * Return date in specified format.
     *
     * @param milliSeconds Date in milliseconds
     * @param dateFormat   Date format
     * @return String representing date in specified format
     */
    public static String getDateForChat(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = new Date(milliSeconds);
        String convertedDate = formatter.format(date.getTime());

        if (isToday(convertedDate, dateFormat)) {
            return "Today";
        } else if (isYesterday(convertedDate, dateFormat)) {
            return "Yesterday";
        }  else if (isTomorrow(convertedDate, dateFormat)) {
            return "Tomorrow";
        } else {
            return convertedDate;
        }
    }

    public  static String getTimeStamp(){
        return String.valueOf(System.currentTimeMillis());
    }

    public static String getTimeStamp2(String datetxt){

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = (Date)formatter.parse(datetxt);
            return String.valueOf(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getTimeStamp();
    }
    public static String getFormattedDate(String dateTxt){
        if(TextUtils.isEmpty(dateTxt)){
            return  "00 00,0000";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM,yyyy", Locale.ENGLISH);
        // Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-04-21T18:08:52.078711+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(getDateFromStringDate(dateTxt,"yyyy-MM-dd'T'HH:mm:ssZZZZZ"));
    }
    public static String getFormattedDate2(String dateTxt){
        if(TextUtils.isEmpty(dateTxt)){
            return  "00 00,0000";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM,yyyy|HH:mm aa", Locale.ENGLISH);
        // Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-04-21T18:08:52.078711+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(getDateFromStringDate(dateTxt,"yyyy-MM-dd HH:mm:ss"));
    }
    public static String getFormattedDate3(String dateTxt){
        if(TextUtils.isEmpty(dateTxt)){
            return  "00 00,0000";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM,yyyy", Locale.ENGLISH);
        // Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-04-21T18:08:52.078711+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(getDateFromStringDate(dateTxt,"yyyy-MM-dd HH:mm:ss"));
    }


    public static String getFormattedTime(String dateTxt){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa", Locale.ENGLISH);
        //  Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-03-21T15:40:10+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(DateUtils.getDateFromStringDate(dateTxt,"yyyy-MM-dd'T'HH:mm:ssZZZZZ"));

    }

    public static String getFormattedTime2(String dateTxt){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa", Locale.ENGLISH);
        //  Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-03-21T15:40:10+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(getDateFromStringDate(dateTxt,"yyyy-MM-dd HH:mm:ss"));

    }

    public static String getFormattedTime3(String dateTxt){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa", Locale.ENGLISH);
        //  Log.e("date", "formatted string: "+sdf.format(DateUtils.getDateFromStringDate("2021-03-21T15:40:10+05:30","yyyy-MM-dd'T'HH:mm:ssZZZZZ")));
        return sdf.format(getDateFromStringDate(dateTxt,"yyyy-MM-dd HH:mm:ss"));

    }

    public static String parseTime(String dateTxt) {
        //String date= String.valueOf(dateTxt+":00:00");
        try {
            Date date1 = new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(dateTxt);
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
            return dateFormat.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isTimeBetweenTwoTime(String initialTime, String finalTime) throws ParseException {

        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        if (initialTime.matches(reg) && finalTime.matches(reg) &&
                getCurrentHour().matches(reg)) {
            boolean valid = false;
            //Start Time
            Log.e("ctime",getCurrentHour());
            //all times are from java.util.Date
            Date inTime = new SimpleDateFormat("HH:mm:ss").parse(initialTime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(inTime);

            //Current Time
            Date checkTime = new SimpleDateFormat("HH:mm:ss").parse(getCurrentHour());
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(checkTime);

            //End Time
            Date finTime = new SimpleDateFormat("HH:mm:ss").parse(finalTime);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(finTime);

            if (finalTime.compareTo(initialTime) < 0) {
                calendar2.add(Calendar.DATE, 1);
                calendar3.add(Calendar.DATE, 1);
            }

            Date actualTime = calendar3.getTime();
            if ((actualTime.after(calendar1.getTime()) ||
                    actualTime.compareTo(calendar1.getTime()) == 0) &&
                    actualTime.before(calendar2.getTime())) {
                valid = true;
                return valid;
            } else {
                return false;
            }
        }
        return false;
    }


    public static String getCurrentHour(){
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        return  currentTime;
    }
    public static Calendar parseDateString(String date) {
        SimpleDateFormat BIRTHDAY_FORMAT_PARSER = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar = Calendar.getInstance();
        BIRTHDAY_FORMAT_PARSER.setLenient(false);
        try {
            calendar.setTime(BIRTHDAY_FORMAT_PARSER.parse(date));
        } catch (ParseException e) {}
        return calendar;
    }

    public static boolean isValidBirthday(String birthday) {
        Calendar calendar = parseDateString(birthday);
        int year = calendar.get(Calendar.YEAR);
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        return year >= 1900 && year < thisYear;
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    private static String getDateToDayConvert() {
        return "";
    }

    public static String getNextWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        System.out.println("Date = "+ cal.getTime());
        return getDate(cal.getTime(), FORECAST_DATE_FORMAT);
    }

    public static String getNextTwoWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 14);
        System.out.println("Date = "+ cal.getTime());
        return getDate(cal.getTime(), FORECAST_DATE_FORMAT);
    }

    public static Date gmttoLocalDate(Date date) {
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
        return local;
    }
    public static Date localToGMT() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gmt = new Date(sdf.format(date));
        return gmt;
    }

    public static Date getCurrentOnlyDateWithoutTime() {
        return DateUtils.getDateFromStringDate(DateUtils.parseStringDate(String.valueOf(new Date()), "EEE MMM dd HH:mm:ss Z yyyy", "EEE MMM dd 00:00:00 Z yyyy"), "EEE MMM dd 00:00:00 Z yyyy");
    }

    public static boolean isCompareToLast24Hours(String startDate, String endDate, String dateFormat) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date1 = sdf.parse(startDate);
            Date date2 = sdf.parse(endDate);

            boolean moreThanDay = Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;

            System.out.println(moreThanDay);
            return moreThanDay;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCompareToLast7Days(String startDate, String endDate, String dateFormat) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date1 = sdf.parse(startDate);
            Date date2 = sdf.parse(endDate);

            boolean moreThanDay = Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_WEEK;

            System.out.println(moreThanDay);
            return moreThanDay;
        } catch (Exception e) {
            return false;
        }
    }

}
