package com.example.intents_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class thirdActivit extends AppCompatActivity {

    private EditText etv1;
    private EditText etv2;
    private Button imgPhone;



    private final int tel_cod = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        getSupportActionBar().hide();

        // Relation //
        etv1 = (EditText)findViewById(R.id.txtView11);
        imgPhone = (Button)findViewById(R.id.btnCall);


    }

    public void funtionButton(View view){
        String PhoneNumber = etv1.getText().toString();
        if(etv1 != null){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, tel_cod);

            }
            else{
                OlderVersions(PhoneNumber);
            }
        }
    }

    private void OlderVersions(String phoneNumber){
        Intent intentcall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber));

        int result = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);

        if(result == PackageManager.PERMISSION_GRANTED){
            startActivity(intentcall);
        }
        else{
            Toast.makeText(this,"Acceso no autorizado", Toast.LENGTH_LONG).show();
        }

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        switch (requestCode){
            case tel_cod:
                String permisos = permissions[0];
                int result = grantResults[0];
                if (permisos.equals(Manifest.permission.CALL_PHONE)){
                    if (result == PackageManager.PERMISSION_GRANTED){
                        String phoneNumber = etv1.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) return;
                        startActivity(intentCall);

                    }
                    else{
                        Toast.makeText(this,"Acceso denegado", Toast.LENGTH_LONG).show();
                    }

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }

    }

    private boolean CheckPermission(String permission){
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }


}