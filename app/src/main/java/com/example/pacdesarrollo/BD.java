package com.example.pacdesarrollo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BD extends SQLiteOpenHelper {

    private static final String TABLA = "alumnos";
    private static final String nombre = "nombre";

    //Constructor
    public BD(Context context) {
        super(context, TABLA, null, 1);
    }

    //Crear la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTabla = "CREATE TABLE alumnos (Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT)";
        db.execSQL(crearTabla);
    }

    //Borra la tabla y crea una nueva vacía
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA);
        db.execSQL(TABLA);
    }


    //Creamos método para que añada datos a nuestra tabla, contruye la sentencia para SQL obteniendo el String
    public boolean añadirDatos(String datoIntroducido) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(nombre, datoIntroducido);

        long resultado = db.insert(TABLA, null, contentValues);

        /// Si no se pueden añadir los datos devuelve -1 ///
        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Método para que nos devuelva los datos creados previamente en la tabla
    public Cursor ObtenerDatos() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLA;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //Borra la tabla y crea una nueva vacía
    public void borrarTabla() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLA);
        String createTable = "CREATE TABLE " + TABLA + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                nombre + " TEXT)";
        db.execSQL(createTable);
    }

}
