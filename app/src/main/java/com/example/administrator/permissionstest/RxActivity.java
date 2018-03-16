package com.example.administrator.permissionstest;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;
import pub.devrel.easypermissions.EasyPermissions;

public class RxActivity extends AppCompatActivity{

    private String TAG= "RxActivity";//READ_EXTERNAL_STORAGE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        TextView permissions = (TextView) findViewById(R.id.permissions);
        permissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   RxPermissions rxPermission = new RxPermissions(RxActivity.this);
                requestPermission();

            }
        });
    }

    public void requestPermission(){
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Consumer<Permission>() {
            @Override
            public void accept(Permission permission) throws Exception {
                if (permission.granted) {
                    // 用户已经同意该权限
                    Toast.makeText(getApplicationContext(),"用户已经同意该权限",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, permission.name + " is granted.");
                } else if (permission.shouldShowRequestPermissionRationale) {
                    // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                    Toast.makeText(getApplicationContext(),"用户拒绝了该权限",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, permission.name + " is denied. More info should be provided.");
                } else {
                    // 用户拒绝了该权限，并且选中『不再询问』
                    Toast.makeText(getApplicationContext(),"用户拒绝了该权限，并且选中『不再询问』",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, permission.name + " is denied.");
                }
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

}