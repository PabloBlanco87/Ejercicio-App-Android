package com.example.pacdesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método asociado a botón que nos envía de la pantalla Main a la pantalla Activity 3
    public void goAct3(View view) {
        Intent intent = new Intent(MainActivity.this, Activity3.class);
        startActivity(intent);
        String texto = "Se encuentra en Activity 3";
        Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
    }

    //Método asociado a botón que nos envía de la pantalla Main a la pantalla Activity 2
    public void goAct2(View view) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
        String texto = "Se encuentra en Activity 2";
        Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
    }
}
