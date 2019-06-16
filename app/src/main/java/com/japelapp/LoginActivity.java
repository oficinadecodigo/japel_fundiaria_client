package com.japelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        verificarPermissoes();
        Intent intent = new Intent(this, FormularioPesquisaActivity.class);
        startActivity(intent);
    }

    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;
    private String[] storage_permissions =
            {
                    Manifest.permission.CAMERA,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

    private void verificarPermissoes() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SYSTEM_ALERT_WINDOW)&&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setMessage("Liberar permissões?");
                builder.setTitle("Permissões");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(LoginActivity.this, storage_permissions, 0);
                        //onContactsClick();
                    }
                });

                builder.show();
            } else {
                ActivityCompat.requestPermissions(this, storage_permissions, 0);
                // onContactsClick();
            }

        }
    }
}
