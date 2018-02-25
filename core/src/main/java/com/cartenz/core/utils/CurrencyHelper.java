package com.cartenz.core.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by pratama on 1/31/2018.
 */

public class CurrencyHelper {

    public static String RP = "Rp. ";

    public static String formatDecimal(String s) {
        String cc;
        try {
            Locale locale = new Locale("en", "UK");

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            String pattern = "###,###.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);

            cc = decimalFormat.format(Double.parseDouble(s)) + "";

        } catch (Exception e) {
            cc = "0";
        }
        return cc;
    }

}
