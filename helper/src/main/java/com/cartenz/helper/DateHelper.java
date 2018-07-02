package com.cartenz.helper;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pratama on 1/31/2018.
 */

public class DateHelper {

    public static String DATE_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT2 = "dd MMMM yyyy";

    public static void datePicker(Context context, final TextView textView) {
        final int year, month, day;
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(context, (view, selectedYear, selectedMonth, selectedDay) -> textView.setText(cekdate(selectedDay, selectedMonth, selectedYear)), year, month, day);
        dpd.show();
    }

    public static String now() {
        return now(DATE_FORMAT1);
    }

    public static String now(String dateformat) {
        Date date = new Date();
//        2017-07-13 15:22:52
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        String formattedDate = df.format(date.getTime());
        return formattedDate;
    }

    private static String cekdate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }


    public static String format(String string, String startFormat, String resultFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(startFormat);
        try {
            Date date = sdf.parse(string);
            SimpleDateFormat sdfFormat = new SimpleDateFormat(resultFormat);
            return sdfFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return string;
        }
    }

}
