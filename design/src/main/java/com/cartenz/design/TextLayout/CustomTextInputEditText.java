package com.cartenz.design.TextLayout;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomTextInputEditText extends TextInputEditText {
    public CustomTextInputEditText(Context context) {
        super(context);
        setBackground();
    }

    public CustomTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground();
    }

    public CustomTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackground();
    }

    private void setBackground() {
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
        int dp = UnitHelper.dpToInt(8);
        setPadding(dp, dp, dp, dp);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setError(null);
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
                return false;
            }
        });
    }


    @Override
    public void setError(CharSequence error) {
        try {
            ViewParent parent = getParent().getParent();
            if (parent instanceof CustomTextInputLayout) {
                setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext_error));
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


}
