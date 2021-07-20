package com.example.permissionpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] permissions  = {"android.permission.CAMERA","android.permission.READ_CALENDAR","android.permission.READ_CONTACTS","android.permission.READ_EXTERNAL_STORAGE","android.permission.INTERNET","android.permission.CALL_PHONE"};
private Button camera,internet,storage,call,contacts,calendar;
private static int permissionCODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera=findViewById(R.id.camera);
        internet=findViewById(R.id.internet);
        storage=findViewById(R.id.storage);
        call=findViewById(R.id.call);
        contacts=findViewById(R.id.contacts);
        calendar=findViewById(R.id.calendar);
camera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkPermission(Manifest.permission.CAMERA,permissionCODE);
    }
});
internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.INTERNET,permissionCODE);
            }
        });
storage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,permissionCODE);
    }
});
    contacts.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkPermission(Manifest.permission.READ_CONTACTS,permissionCODE);
        }
    });
    calendar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkPermission(Manifest.permission.READ_CALENDAR,permissionCODE);
        }
    });
    call.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkPermission(Manifest.permission.CALL_PHONE,permissionCODE);
        }
    });}
public void onRequestPermissionsResult(int requestCODE,String[] permissions,int[] grantResults) {
    super.onRequestPermissionsResult(requestCODE, permissions, grantResults);
if(requestCODE==permissionCODE){
    if((grantResults.length>0) && grantResults[0]==PackageManager.PERMISSION_GRANTED){
        Toast.makeText(this,"PERMISSION GRANTED",Toast.LENGTH_SHORT).show();
    }
    else
    {Toast.makeText(this,"PERMISSION DENIED",Toast.LENGTH_SHORT).show();
    }
}

    }
    private void checkPermission(String permissions, int requestCODE) {
        if(ContextCompat.checkSelfPermission(MainActivity.this,permissions)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {permissions},requestCODE);
        }
    else
        {Toast.makeText(this,"PERMISSION HAS ALREADY BEEN GRANTED",Toast.LENGTH_SHORT).show();
        }
    }
}