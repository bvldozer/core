package com.cartenz.design.textlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomTextInputEditText extends TextInputEditText {

    private int DEFAULT = 0;
    private String units;
    private int unitsTextColor = DEFAULT;
    private Drawable unitDrawable;

    public CustomTextInputEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomInputLayout, defStyleAttr, 0);
        units = typedArray.getString(R.styleable.CustomInputLayout_units);
        unitsTextColor = typedArray.getColor(R.styleable.CustomInputLayout_unitsColor, DEFAULT);


        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
        int dp = UnitHelper.dpToInt(8);
        int dpx = dp;
        if (getInputType() != InputType.TYPE_TEXT_VARIATION_PASSWORD) {
            dpx = UnitHelper.dpToInt(16);
        }
        setPadding(dp, dpx, dp, dpx);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setError(null);
                try {
                    ViewParent parent = getParent().getParent().getParent();
                    if (parent instanceof CustomInputLayout) {
                        CustomInputLayout linearLayout = ((CustomInputLayout) parent);
                        linearLayout.setTvError(null);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
                return false;
            }
        });

        setUnits(units, unitsTextColor);

    }


    @Override
    public void setError(CharSequence error) {
        requestFocus();
        try {
            if (error == null) {
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
                if (unitDrawable != null) {
                    if (unitsTextColor == DEFAULT) {
                        unitsTextColor = ContextCompat.getColor(getContext(), R.color.black_2);
                    }
                    unitDrawable.setColorFilter(new PorterDuffColorFilter(unitsTextColor, PorterDuff.Mode.SRC_IN));
                }
            } else {
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext_error));
                if (unitDrawable != null) {
                    unitDrawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.red_1), PorterDuff.Mode.SRC_IN));
                }
            }
            return;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        super.setError(error);
    }

    public void setUnits(String string) {
        setUnits(string, DEFAULT);
    }

    public void setUnits(String string, int unitsTextColor) {
        try {
            if (!TextUtils.isEmpty(string)) {
                int width = string.length() * 24;
                int height = 64;
                Bitmap canvasBitmap = Bitmap.createBitmap(width, height,
                        Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(canvasBitmap);
                Paint imagePaint = new Paint();
                imagePaint.setTextAlign(Paint.Align.RIGHT);
                imagePaint.setTextSize(getTextSize() * 2 / 3);
                canvas.drawText(string, width, height / 2, imagePaint);
                unitDrawable = new BitmapDrawable(getResources(), canvasBitmap);
                if (unitsTextColor == DEFAULT) {
                    unitsTextColor = ContextCompat.getColor(getContext(), R.color.black_2);
                }
                unitDrawable.setColorFilter(new PorterDuffColorFilter(unitsTextColor, PorterDuff.Mode.SRC_IN));
                setCompoundDrawablesWithIntrinsicBounds(null, null, unitDrawable, null);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


}
