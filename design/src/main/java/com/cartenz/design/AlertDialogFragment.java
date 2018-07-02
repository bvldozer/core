package com.cartenz.design;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.cartenz.design.R;



public class AlertDialogFragment extends DialogFragment {

    public static String TAG = "TAG";
    private Fragment fragment;

    public AlertDialogFragment() {

    }

    @SuppressLint("ValidFragment")
    public AlertDialogFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public static AlertDialogFragment newInstance(Fragment frag) {
        AlertDialogFragment fragment = new AlertDialogFragment(frag);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, container);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(true);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.frameAlert, fragment, TAG).commit();
        return view;
    }

    public static void showAlert(AppCompatActivity activity, Fragment fragment) {
        try {
            setDismiss(activity);
            FragmentManager fm = activity.getSupportFragmentManager();
            AlertDialogFragment dialog = new AlertDialogFragment(fragment);
            dialog.show(fm, AlertDialogFragment.TAG);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void setDismiss(AppCompatActivity activity) {
        try {
            Fragment prev = activity.getSupportFragmentManager().findFragmentByTag(AlertDialogFragment.TAG);
            if (prev != null) {
                DialogFragment df = (DialogFragment) prev;
                df.dismiss();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
