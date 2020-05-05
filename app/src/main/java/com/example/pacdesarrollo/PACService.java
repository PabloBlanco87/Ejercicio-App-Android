package com.example.pacdesarrollo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PACService extends Service {

    //Declaramos variable MediaPlayer y un IBinder
    private MediaPlayer mediaPlayer;
    private final IBinder iBinder = new LocalBinder();

    /* Creamos servicio con ayuda de Binder
     * De estos links he sacado la información para utilizar LocalBinder
     * https://riptutorial.com/es/android/example/4635/creando-servicio-bound-con-ayuda-de-binder
     * https://developer.android.com/guide/components/bound-services?hl=es-419
     */
    class LocalBinder extends Binder {
        PACService getService() {
            return PACService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    //Método para iniciar el Serivicio
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "El Servicio se ha iniciado", Toast.LENGTH_SHORT).show();
        /*
        START_STICKY y START_NOT_STICKY:
        Ambos códigos solo son relevantes cuando el teléfono se queda sin memoria y mata el
        servicio antes de que termine de ejecutarse. START_STICKY le dice al sistema operativo que
        vuelva a crear el servicio después de que tenga suficiente memoria y vuelva a llamar a
        onStartCommand() con una intención nula. START_NOT_STICKY le dice al sistema operativo que
        no se moleste en volver a crear el servicio nuevamente.
        https://www.it-swarm.net/es/android/start-sticky-y-start-not-sticky/942814231/
        https://developer.android.com/reference/android/app/Service.html?hl=es-419#START_STICKY
         */
        return START_STICKY;
    }

    //
    public void playMusic() {
        Toast.makeText(this, "Reproduciendo música", Toast.LENGTH_SHORT).show();
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tetrissong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    public void stopMusic() {
        Toast.makeText(this, "Música detenida", Toast.LENGTH_SHORT).show();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    public void detenerAplicacion() {
        Toast.makeText(this, "Aplicación bloqueada", Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}
