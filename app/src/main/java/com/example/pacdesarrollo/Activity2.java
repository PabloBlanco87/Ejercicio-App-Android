package com.example.pacdesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button b_volver, b_insertar, b_mostrar, b_crear;
    EditText editText;
    BD bd = new BD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        b_volver = (Button) findViewById(R.id.atras);
        b_insertar = (Button) findViewById(R.id.insertar);
        b_mostrar = (Button) findViewById(R.id.mostrar);
        b_crear = (Button) findViewById(R.id.crear);
        editText = (EditText) findViewById(R.id.insertarTexto);

        b_volver.setOnClickListener(this);
        b_insertar.setOnClickListener(this);
        b_mostrar.setOnClickListener(this);
        b_crear.setOnClickListener(this);
    }

    /*Creamos método onClick: mediante una estructura switch-case hará la acción que seleccionemos en cada botón:
     * Crear nueva tabla
     * Insertar datos
     * Mostrar datos
     * Volver atrás*/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.crear:
                bd.borrarTabla();
                break;
            case R.id.insertar:
                if (bd != null) {
                    //Si no se escribe nada en el editText, saldrá un Toast al usuario
                    if (editText.getText().length() > 0) {
                        bd.añadirDatos(editText.getText().toString());
                    } else {
                        Toast.makeText(this, "No ha introducido ningún nombre", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.mostrar:
                Intent intent = new Intent(Activity2.this, Activity2Auxiliar.class);
                startActivity(intent);
                break;
            case R.id.atras:
                Intent intent2 = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent2);
                Toast.makeText(this, "Se encuentra en la pantalla principal", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}


