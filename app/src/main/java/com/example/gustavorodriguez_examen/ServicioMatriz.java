package com.example.gustavorodriguez_examen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ServicioMatriz extends Service {

    int n;

    public void onCreate(){
        super.onCreate();

//        etNumero = (EditText)
//
//        n =
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
