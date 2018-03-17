package com.cartenz.core.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by pratama on 3/17/2018.
 */

public class WizardUtils {

    public static boolean editTextIsEmpty(EditText editText) {
        if (editText != null) {
            if (TextUtils.isEmpty(editText.getText())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void disableView(View view) {
        if (view instanceof TextView) {
            TextView text = (TextView) view;
            text.setFocusable(false);
            text.setFocusableInTouchMode(false);
            text.setEnabled(false);

        } else if (view instanceof Spinner) {

            Spinner spinner = (Spinner) view;
            if (spinner.getAdapter() != null) {
                spinner.setEnabled(false);
                spinner.setClickable(false);
            }

        }
    }

    public static void enableView(View view) {
        if (view instanceof TextView) {
            TextView text = (TextView) view;
            text.setFocusable(true);
            text.setFocusableInTouchMode(true);
            text.setEnabled(true);

        } else if (view instanceof Spinner) {

            Spinner spinner = (Spinner) view;
            if (spinner.getAdapter() != null) {
                spinner.setEnabled(true);
                spinner.setClickable(true);
            }

        }
    }

}
