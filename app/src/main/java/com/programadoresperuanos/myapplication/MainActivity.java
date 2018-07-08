package com.programadoresperuanos.myapplication;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.mensaje);
        if(ActivityCompat.checkSelfPermission(MainActivity.this,CAMERA) == PackageManager.PERMISSION_GRANTED){
            String mensaje = "La camara ya se puede usar.";
            t.setText(mensaje);
        }else{
            String mensaje2 = "El permiso es necesario para usar la camara.";
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,CAMERA)){
                t.setText(mensaje2);
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{CAMERA},150);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{CAMERA},150);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        String mensaje3 = "Acabas de terminar de otorgar permisos.";
        t.setText(mensaje3);
    }
}
