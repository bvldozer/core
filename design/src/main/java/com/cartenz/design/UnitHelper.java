package com.cartenz.design;

import android.content.res.Resources;

public class UnitHelper {
    public static int dpToInt(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int intToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }


}
