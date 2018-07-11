package com.cartenz.design.textlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomInputLayout extends LinearLayout {
    private int DEFAULT = 0;

    private String hint;
    private boolean isSpinner = false;

    private int errorBackgroundColor;
    private int errorTextColor;
    private boolean errorEnabled;
    private String units;
    private int unitsTextColor = DEFAULT;

    private CustomTextInputLayout customTextInputLayout;
    private CustomTextInputEditText customTextInputEditText;
    private CustomSpinner customSpinner;
    private TextView tvError;

    public CustomInputLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomInputLayout, defStyleAttr, 0);
        units = typedArray.getString(R.styleable.CustomInputLayout_units);
        unitsTextColor = typedArray.getColor(R.styleable.CustomInputLayout_unitsTextColor, DEFAULT);

        hint = typedArray.getString(R.styleable.CustomInputLayout_hint);
        isSpinner = typedArray.getBoolean(R.styleable.CustomInputLayout_isSpinner, false);
        errorEnabled = typedArray.getBoolean(R.styleable.CustomInputLayout_errorEnable, false);
        errorBackgroundColor = typedArray.getColor(R.styleable.CustomInputLayout_errorBackgroundColor, 0);
        errorTextColor = typedArray.getColor(R.styleable.CustomInputLayout_errorTextColor, ContextCompat.getColor(getContext(), R.color.red_1));

        this.setOrientation(VERTICAL);

        if (isSpinner) {
            customSpinner = new CustomSpinner(context);
            customSpinner.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        } else {
            customTextInputEditText = new CustomTextInputEditText(context);
            customTextInputEditText.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            customTextInputEditText.setUnits(units, unitsTextColor);
        }
        customTextInputLayout = new CustomTextInputLayout(context);
        customTextInputLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        if (!TextUtils.isEmpty(hint)) {
            customTextInputLayout.setHint(hint);
        }
        if (isSpinner) {
            customTextInputLayout.addView(customSpinner);
        } else {
            customTextInputLayout.addView(customTextInputEditText);
        }
        this.addView(customTextInputLayout);
        setErrorEnabled(errorEnabled);

    }


    public void setError(String error) {
        setTextErrorInputLayout(error);
    }

    public Editable getText() {
        if (isSpinner) {
            //todo isspinner
            return customSpinner.getText();
        } else {
            return customTextInputEditText.getText();
        }
    }

    public void setText(String string) {
        if (isSpinner) {
            customSpinner.setText(string);
        } else {
            customTextInputEditText.setText(string);
        }
    }

    public void setErrorEnabled(boolean enabled) {
        if (enabled) {
            try {
                if (errorTextColor != 0 || errorBackgroundColor != 0) {
                    int dp = UnitHelper.dpToInt(8);
                    tvError = new AppCompatTextView(getContext());
                    tvError.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                    tvError.setPadding(dp, dp, dp, dp);
                    if (errorBackgroundColor != 0) {
                        tvError.setBackgroundColor(errorBackgroundColor);
                    }
                    if (errorTextColor == 0) {
                        errorTextColor = ContextCompat.getColor(getContext(), R.color.red_1);
                    }
                    tvError.setTextColor(errorTextColor);
                    this.addView(tvError);
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

    public void setTextErrorInputLayout(CharSequence error) {
        if (!TextUtils.isEmpty(error)) {
            setTvError(error);
            customTextInputLayout.setHintAnimationEnabled(false);
            if (isSpinner) {
                customSpinner.setError(error);
            } else {
                customTextInputEditText.setError(error);
            }
        } else {
            setTvError(null);
            customTextInputLayout.setHintAnimationEnabled(true);
            if (isSpinner) {
                customSpinner.setError(null);
            } else {
                customTextInputEditText.setError(null);
            }
        }

    }

    public void setTvError(CharSequence string) {
        if (tvError != null) {
            tvError.setText(string);
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        if (isSpinner) {
            customSpinner.setAdapter(adapter);
        }
    }


    public void setSelectedPosition(int position) {
        if (isSpinner) {
            customSpinner.setSelectedPosition(position);
        }
    }

    public int getSelectedPosition() {
        if (isSpinner) {
            return customSpinner.getSelectedPosition();
        }
        return -1;
    }


}