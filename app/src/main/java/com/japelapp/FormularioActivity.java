package com.japelapp;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.japelapp.ui.formulario.SectionsPagerAdapter;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        verificarPermissoes();
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
                        ActivityCompat.requestPermissions(FormularioActivity.this, storage_permissions, 0);
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