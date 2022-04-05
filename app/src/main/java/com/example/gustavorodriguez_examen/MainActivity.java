package com.example.gustavorodriguez_examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMostrar;
    EditText etDimension;
    LinearLayout sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = findViewById(R.id.xbtnMostrar);
        etDimension = findViewById(R.id.xetDimension);
        sl = findViewById(R.id.secondaryLayout);


        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();

                String handler = etDimension.getText().toString();
                int n = Integer.parseInt(handler);

                if ( n%2 == 0 || etDimension.getText().length() == 0 ) {
                    Toast.makeText(MainActivity.this, "Ingrese un numero natural impar", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(MainActivity.this, "Cargando resultado", Toast.LENGTH_SHORT).show();
                    sl.setVisibility(View.GONE);


                    Resultados fragmentResults = new Resultados();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentResults);
                    fragmentTransaction.commit();
                }



            }
        });

    }
}