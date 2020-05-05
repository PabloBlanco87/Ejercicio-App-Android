package com.example.pacdesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    //Creamos un objeto PACService para poder utilizar sus métodos
    PACService pacService;


    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    //Método asociado a botón que nos envía de la pantalla Activity 3 a la pantalla Main Activity
    public void goHomeNew(View view) {
        Intent intent = new Intent(Activity3.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Se encuentra en la pantalla principal", Toast.LENGTH_SHORT).show();
        finish();
    }

    //Método que se comunica con el Service y hace que reproduzca la música que él contiene
    public void reproducirMusica(View v) {
        pacService.playMusic();
    }

    //Método que se comunica con el Service y hace que detenga la música que él contiene
    public void pararMusica(View v) {
        pacService.stopMusic();
    }

    //Método que se comunica con el Service y hace que la APP se bloquee durante 15 segundos
    public void detenerAplicacion(View v) {
        pacService.detenerAplicacion();
    }

    //Método que inicia el Service
    public void iniciarServicio(View v) {
        Intent intent = new Intent(this, PACService.class);
        startService(intent);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    //Método que detiene el Service
    public void detenerServicio(View v) {
        Intent intent = new Intent(this, PACService.class);
        pacService.stopMusic();
        stopService(intent);
    }

    //Método que conecta con el servicio
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PACService.LocalBinder binder = (PACService.LocalBinder) iBinder;
            pacService = binder.getService();
            flag = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            flag = false;
        }
    };

}
