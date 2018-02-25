package com.cartenz.core.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class CheckPermission {
    final public static String CAMERA = "camera";
    final public static String NETWORK = "network";
    final public static String WRITE_EXTERNAL_STORAGE = "Write External Storage";
    final public static String READ_EXTERNAL_STORAGE = "Read External Storage";
    final public static String READ_PHONE_STORAGE = "Read Phone Storage";
    final public static String LOCATION = "Location";
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    private Context context;
    final public static List<String> permissionsNeeded = new ArrayList<>();

    public CheckPermission(Context context) {
        this.context = context;
    }

    public boolean check(List requestList) {
        final List<String> permissionsList = new ArrayList<>();


        if (requestList.contains(NETWORK) && !addPermission(context, permissionsList, Manifest.permission.ACCESS_NETWORK_STATE))
            permissionsNeeded.add("Network");

        if (requestList.contains(LOCATION)) {
            if (!addPermission(context, permissionsList, Manifest.permission.ACCESS_FINE_LOCATION))
                permissionsNeeded.add("Location");

            if (!addPermission(context, permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
                permissionsNeeded.add("Location");
        }

        if (requestList.contains(CAMERA)) {
            if (!addPermission(context, permissionsList, Manifest.permission.CAMERA))
                permissionsNeeded.add("Camera");
        }

        if (requestList.contains(WRITE_EXTERNAL_STORAGE)) {
            if (!addPermission(context, permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
                permissionsNeeded.add("Write External Storage");
        }

        if (requestList.contains(READ_EXTERNAL_STORAGE)) {
            if (!addPermission(context, permissionsList, Manifest.permission.READ_EXTERNAL_STORAGE))
                permissionsNeeded.add("Read External Storage");
        }

        if (requestList.contains(READ_PHONE_STORAGE)) {
            if (!addPermission(context, permissionsList, Manifest.permission.READ_PHONE_STATE))
                permissionsNeeded.add("Read Phone Storage");
        }

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                ActivityCompat.requestPermissions((Activity) context, permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
            ActivityCompat.requestPermissions((Activity) context, permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            return false;
        } else {
            return true;
        }


    }


    private boolean addPermission(Context context, List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            if (!ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission))
                return false;
        }
        return true;
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


}