package com.ion_popescu.laborator3.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


public class ToastService extends Service {
    private static boolean status=false;
    private final String TAG="Toast Service";
    private Handler handler;
    private Runnable runnable;

    public ToastService() {

    }

    @Override
    public void onCreate() {
        handler=new Handler(Looper.getMainLooper());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        status=true;
        handler.post(runnable=new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ToastService.this, "Laborator 3", Toast.LENGTH_SHORT).show();
                handler.postDelayed(this,10000);
            }
        });
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        status=false;
        Log.i(TAG, "onDestroy: ");
        handler.removeCallbacks(runnable);
    }


    public static boolean isStatus() {
        return status;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}