package com.cartenz.design.TextLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomTextInputLayout extends TextInputLayout implements TextInputListener {
    private int errorBackgroundColor;
    private int errorTextColor;
    private boolean errorEnabled;
    private TextView tvError;

    public CustomTextInputLayout(Context context) {
        super(context);
        setBackground(context, null, 0);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(context, attrs, 0);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackground(context, attrs, defStyleAttr);

    }

    private void setBackground(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextInputLayout, defStyleAttr, 0);
        errorEnabled = typedArray.getBoolean(android.support.design.R.styleable.TextInputLayout_errorEnabled, false);
        errorBackgroundColor = typedArray.getColor(R.styleable.CustomTextInputLayout_errorBackgroundColor, 0);
        errorTextColor = typedArray.getColor(R.styleable.CustomTextInputLayout_errorTextColor, ContextCompat.getColor(getContext(), R.color.red_1));

        int dp = UnitHelper.dpToInt(4);
        setPadding(0, dp, 0, 0);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_layout));
        setErrorEnabled(errorEnabled);
    }

    @Override
    public void setErrorEnabled(boolean enabled) {
        if (enabled) {
            try {
                if (errorTextColor != 0 || errorBackgroundColor != 0) {
                    int dp = UnitHelper.dpToInt(8);
                    if (errorTextColor == 0) {
                        errorTextColor = ContextCompat.getColor(getContext(), R.color.red_1);
                    }
                    if (errorBackgroundColor == 0) {
                        errorBackgroundColor = ContextCompat.getColor(getContext(), R.color.white_3);
                    }
                    CustomTextInputLayout customTextInputLayout = (CustomTextInputLayout) getRootView();
                    tvError = new AppCompatTextView(getContext());
                    tvError.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                    tvError.setPadding(dp, dp, dp, dp);
                    tvError.setTextColor(errorTextColor);
                    tvError.setBackgroundColor(errorBackgroundColor);
                    customTextInputLayout.addView(tvError);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

    }


    public int getErrorBackgroundColor() {
        return errorBackgroundColor;
    }

    public void setErrorBackgroundColor(int errorBackgroundColor) {
        this.errorBackgroundColor = errorBackgroundColor;
    }

    public int getErrorTextColor() {
        return errorTextColor;
    }

    public void setErrorTextColor(int errorTextColor) {
        this.errorTextColor = errorTextColor;
    }


    @Override
    public void setTextErrorInputLayout(CharSequence error) {
        if (tvError != null) {
            if (!TextUtils.isEmpty(error)) {
                setHintAnimationEnabled(false);
                tvError.setText(error);
            } else {
                tvError.setText(null);
            }
        } else {
            tvError.setText(null);
        }
    }
}
