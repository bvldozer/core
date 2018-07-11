package com.cartenz.design.textlayout;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomTextInputLayout extends TextInputLayout {

    public CustomTextInputLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        int dp = UnitHelper.dpToInt(4);
        setPadding(0, dp, 0, 0);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_layout));
    }


}
