package com.example.intents_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton_1;
    private Transition transitition;
    private static long Duration_Transition = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        boton_1 = (Button)findViewById(R.id.btnGo);
    }

    public void goActivity(View view){
      Intent intento = new Intent(MainActivity.this, thirdActivit.class);
      startActivity(intento);

    }

}