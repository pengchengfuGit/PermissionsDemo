package com.example.administrator.permissionstest;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class EasyActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final int RC_CALL_PHONE = 0;
    private String TAG= "EasyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        TextView permissions = (TextView) findViewById(R.id.permissions);
        permissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] perms = {Manifest.permission.CALL_PHONE};
                EasyPermissions.requestPermissions(EasyActivity.this, "直接拨打电话的权限",
                        RC_CALL_PHONE, perms);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //Forward results to EasyPermissions
        Toast.makeText(getApplicationContext(), "onRequestPermissionsResult    requestCode" + requestCode, Toast.LENGTH_LONG).show();
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (perms != null && perms.size() > 0)
            for (String item : perms) {
                Log.d(TAG,"onPermissionsGranted    "+item);
            }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (perms != null && perms.size() > 0)
            for (String item : perms) {
                Log.d(TAG,"onPermissionsDenied    "+item);
            }
    }
}