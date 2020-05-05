package com.example.pacdesarrollo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity2Auxiliar extends AppCompatActivity {

    //Declaramos un objeto BD para poder utilizar sus métodos
    BD bd;

    //Declaramos el ListView que mostrará los datos creados en nuestra tabla
    private ListView miViewDeAlumnos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        miViewDeAlumnos = (ListView) findViewById(R.id.listView);
        bd = new BD(this);
        muestraTabla();
    }

    private void muestraTabla() {
        //Obtenemos datos y los metemos en la lista
        Cursor cursor = bd.ObtenerDatos();
        ArrayList<String> listaAlumnos = new ArrayList<>();
        while (cursor.moveToNext()) {
            //Añade todos los datos de la columna 1 al ArrayList
            listaAlumnos.add(cursor.getString(1));
        }
        //Creamos el ListAdapter
        ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaAlumnos);
        miViewDeAlumnos.setAdapter(adaptador);
    }

    public void volverAtras2(View view) {
        Intent intent = new Intent(Activity2Auxiliar.this, Activity2.class);
        startActivity(intent);
        finish();
    }

}