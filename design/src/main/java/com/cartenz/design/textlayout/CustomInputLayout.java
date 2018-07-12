package com.cartenz.design.textlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;
import com.cartenz.design.ViewHelper;

public class CustomInputLayout extends LinearLayout {
    public static int DEFAULT = 0;

    private String text;
    private float textSize;
    private String hint;
    //    private int hintColor = DEFAULT;
    private boolean isSpinner = false;

    private int errorBackgroundColor;
    private int errorTextColor;
    private boolean errorEnabled;
    private boolean singleLine = true;
    private String units;
    private int unitsTextColor = DEFAULT;

    private boolean isFocusable = true;
    private int background;
    private int tint;
    private int drawableRight;
    private int drawableLeft;

    private int inputType = DEFAULT;

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

        inputType = typedArray.getInt(R.styleable.CustomInputLayout_fieldInputType, DEFAULT);
        text = typedArray.getString(R.styleable.CustomInputLayout_text);

        textSize = typedArray.getDimension(R.styleable.CustomInputLayout_textSize, context.getResources().getDimension(R.dimen.font_medium)) / scale();

        units = typedArray.getString(R.styleable.CustomInputLayout_units);
        unitsTextColor = typedArray.getColor(R.styleable.CustomInputLayout_unitsColor, DEFAULT);

        hint = typedArray.getString(R.styleable.CustomInputLayout_hint);
//        hintColor = typedArray.getColor(R.styleable.CustomInputLayout_hintColor, DEFAULT);
        isSpinner = typedArray.getBoolean(R.styleable.CustomInputLayout_isSpinner, false);
        errorEnabled = typedArray.getBoolean(R.styleable.CustomInputLayout_errorEnable, false);
        singleLine = typedArray.getBoolean(R.styleable.CustomInputLayout_singleLine, true);
        errorBackgroundColor = typedArray.getColor(R.styleable.CustomInputLayout_errorBackgroundColor, 0);
        errorTextColor = typedArray.getColor(R.styleable.CustomInputLayout_errorTextColor, ContextCompat.getColor(getContext(), R.color.red_1));
        isFocusable = typedArray.getBoolean(R.styleable.CustomInputLayout_isFocusable, true);

        background = typedArray.getResourceId(R.styleable.CustomInputLayout_fieldBackground, DEFAULT);
        tint = typedArray.getColor(R.styleable.CustomInputLayout_fieldTint, DEFAULT);
        drawableLeft = typedArray.getResourceId(R.styleable.CustomInputLayout_drawableLeft, DEFAULT);
        drawableRight = typedArray.getResourceId(R.styleable.CustomInputLayout_drawableRight, DEFAULT);
        this.setOrientation(VERTICAL);

        if (isSpinner) {
            customSpinner = new CustomSpinner(context);
            customSpinner.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            if (drawableLeft != DEFAULT) {
                customSpinner.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, 0, 0, 0);
            }
            if (drawableRight != DEFAULT) {
                customSpinner.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRight, 0);
            }
            if (!isFocusable) {
                ViewHelper.disableView(customSpinner);
            }
            customSpinner.setSingleLine(singleLine);
            customSpinner.setTextSize(textSize);
            customSpinner.setInputType(inputType);
        } else {
            customTextInputEditText = new CustomTextInputEditText(context);

            customTextInputEditText.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            customTextInputEditText.setUnits(units, unitsTextColor);
            customTextInputEditText.setTextSize(textSize);
            if (inputType == InputType.TYPE_TEXT_FLAG_MULTI_LINE) {
                singleLine = false;
                customTextInputEditText.setMinHeight(UnitHelper.dpToInt(80));
                customTextInputEditText.setGravity(Gravity.TOP | Gravity.LEFT);
            }
            customTextInputEditText.setSingleLine(singleLine);

            if (drawableLeft != DEFAULT) {
                customTextInputEditText.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, 0, 0, 0);
            }
            if (drawableRight != DEFAULT) {
                customTextInputEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRight, 0);
            }
            if (!isFocusable) {
                ViewHelper.disableView(customTextInputEditText);
            }
            if (!TextUtils.isEmpty(text)) {
                customTextInputEditText.setText(text);
            }

            if (inputType != DEFAULT) {
                customTextInputEditText.setInputType(InputType.TYPE_CLASS_TEXT | inputType);
                customTextInputEditText.setSelection(customTextInputEditText.getText().length());
            }

        }

        customTextInputLayout = new CustomTextInputLayout(context);
        customTextInputLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        if (!TextUtils.isEmpty(hint)) {
            customTextInputLayout.setHint(hint);
        }
        if (inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
            customTextInputLayout.setPasswordVisibilityToggleEnabled(true);
        }

        if (isSpinner) {
            customTextInputLayout.addView(customSpinner);
        } else {
            customTextInputLayout.addView(customTextInputEditText);
        }
        if (tint != DEFAULT) {
            customTextInputLayout.getBackground().setColorFilter(new PorterDuffColorFilter(tint, PorterDuff.Mode.SRC_IN));
        }
        if (background != DEFAULT) {
            customTextInputLayout.setBackground(ContextCompat.getDrawable(getContext(), background));
        }

        this.addView(customTextInputLayout);
        setErrorEnabled(errorEnabled);

    }

    private float scale() {
        return getResources().getDisplayMetrics().density;
    }

    public void setTextSize(float textSize) {
        if (isSpinner) {
            customSpinner.setTextSize(textSize);
        } else {
            customTextInputEditText.setTextSize(textSize);
        }
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

    public CustomTextInputLayout getCustomTextInputLayout() {
        return customTextInputLayout;
    }

    public CustomTextInputEditText getCustomTextInputEditText() {
        return customTextInputEditText;
    }

    public CustomSpinner getCustomSpinner() {
        return customSpinner;
    }

    public TextView getTvError() {
        return tvError;
    }
}
