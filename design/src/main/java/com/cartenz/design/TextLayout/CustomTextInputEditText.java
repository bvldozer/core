package com.cartenz.design.TextLayout;

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
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextInputEditText, defStyleAttr, 0);
        units = typedArray.getString(R.styleable.CustomTextInputEditText_units);
        unitsTextColor = typedArray.getColor(R.styleable.CustomTextInputLayout_errorTextColor, DEFAULT);

        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
        int dp = UnitHelper.dpToInt(8);
        setPadding(dp, dp, dp, dp);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setError(null);
                if (unitDrawable != null) {
                    unitDrawable.setColorFilter(new PorterDuffColorFilter(unitsTextColor, PorterDuff.Mode.SRC_IN));
                }
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
                return false;
            }
        });

        setUnits(units);

    }


    @Override
    public void setError(CharSequence error) {
        try {
            ViewParent parent = getParent().getParent();
            if (parent instanceof TextInputListener) {
                if (unitDrawable != null) {
                    unitDrawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.red_1), PorterDuff.Mode.SRC_IN));
                }
                if(error == null){
                    setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
                }else {
                    setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext_error));
                }
                CustomTextInputLayout customTextInputLayout = ((CustomTextInputLayout) parent);
                customTextInputLayout.setTextErrorInputLayout(error);
                requestFocus();
                return;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        super.setError(error);
    }

    public void setUnits(String string) {
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
