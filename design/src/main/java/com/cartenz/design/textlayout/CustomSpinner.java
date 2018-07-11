package com.cartenz.design.textlayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.cartenz.design.R;
import com.cartenz.design.UnitHelper;

public class CustomSpinner extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    private int selectedPosition = -1;
    private String selectedText = null;

    public CustomSpinner(Context context) {
        super(context);
        init(context, null, 0);

    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.setFocusable(false);
        this.setFocusableInTouchMode(false);
        this.setClickable(true);
        int dp = UnitHelper.dpToInt(8);
        this.setPadding(dp, dp, dp, dp);
        this.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_24dp, 0);
        this.setCursorVisible(false);

        this.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CustomSpinner.this.showDropDown();
                selectedPosition = i;
                selectedText = adapterView.getItemAtPosition(i).toString();
                CustomSpinner.this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_24dp, 0);
            }
        });

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ViewParent parent = getParent().getParent().getParent();
                    if (parent instanceof CustomInputLayout) {
                        CustomInputLayout linearLayout = ((CustomInputLayout) parent);
                        linearLayout.setTvError(null);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                CustomSpinner.this.setError(null);
                CustomSpinner.this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_blue_24dp, 0);
                if (!TextUtils.isEmpty(CustomSpinner.this.getText())) {
                    ((ArrayAdapter) CustomSpinner.this.getAdapter()).getFilter().filter(null);
                }
                CustomSpinner.this.showDropDown();

            }
        });

    }

    @Override
    public void setError(CharSequence error) {
        if (error == null) {
            this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_24dp, 0);
            this.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext));
        } else {
            this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_red_24dp, 0);
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_text_input_edittext_error));
        }
        requestFocus();
        return;


    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        selectedText = this.getAdapter().getItem(selectedPosition).toString();
        this.setText(selectedText);
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public String getSelectedText() {
        return selectedText;
    }

}
