package com.glovec.gcedit.utils;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by everyone on 2017/4/12.
 */

public class RequestPermissionHub {

    public static boolean requestNecessaryPermission(final Activity context, OnPermissionsGrantResult onPermissionsGrantResult) {


        return requestPermission(context, new String[]{Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA}, onPermissionsGrantResult);
    }

    public static boolean requestPermission(final Activity context, String[] permissions, OnPermissionsGrantResult onPermissionsGrantResult) {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.CALL_PHONE)) {
                ActivityCompat.requestPermissions(context, permissions, 200);


                Toast.makeText(context, "Permission", Toast.LENGTH_SHORT).show();

            } else{

                new AlertDialog.Builder(context).setTitle("申请权限").setMessage("为什么要申请权限？")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE,
                                        Manifest.permission.CAMERA}, 200);
                            }
                        }).show();
            }
        }

        return false;
    }

    public interface OnPermissionsGrantResult {
        /**
         * @param granted    是否授予成功
         * @param permission 要授予的权限名称
         */
        void onPermissionsGrantResult(boolean granted, String... permission);
    }
}
// button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CALL_PHONE) !=
//                        PackageManager.PERMISSION_GRANTED) {
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(LoginActivity.this, Manifest.permission.CALL_PHONE)) {
//                        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CALL_PHONE,
//                                Manifest.permission.CAMERA}, 200);
//                        Toast.makeText(LoginActivity.this, "Permission", Toast.LENGTH_SHORT).show();
//
//                    } else{
//                        new AlertDialog.Builder(LoginActivity.this).setTitle("申请权限").setMessage("为什么要申请权限？")
//                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CALL_PHONE,
//                                                Manifest.permission.CAMERA}, 200);
//                                    }
//                                }).show();
//                    }
//                } else {
//                    Intent intent = new Intent(Intent.ACTION_CALL);
//                    Uri data = Uri.parse("tel:" + "10086");
//                    intent.setData(data);
//                    startActivity(intent);
//                }
//            }
//        });
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 200) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                Toast.makeText(LoginActivity.this, "call Permission GRANTED", Toast.LENGTH_SHORT).show();
//            } else {
//                // Permission Denied
//                Toast.makeText(LoginActivity.this, "call  Permission Denied", Toast.LENGTH_SHORT).show();
//            }if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//
//                Toast.makeText(LoginActivity.this, "camera Permission GRANTED", Toast.LENGTH_SHORT).show();
//            } else {
//                // Permission Denied
//                Toast.makeText(LoginActivity.this, "camera  Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//            return;
//        }
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }