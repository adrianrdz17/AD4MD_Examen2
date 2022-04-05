package com.example.gustavorodriguez_examen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Resultados extends Fragment {

    Button btnOtro, btnSalir;
    TableLayout tableLayout;
    int size;
    String handler;
    EditText etSize;
    TextView tamanio;

    public Resultados() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            Toast.makeText(this, "fragment creado", Toast.LENGTH_SHORT).show();
//        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView = inflater.inflate(R.layout.fragment_resultados, container, false);
        tableLayout = fragmentView.findViewById(R.id.table);


        etSize = getActivity().findViewById(R.id.xetDimension);
        handler = etSize.getText().toString();
        size = Integer.parseInt(handler);

        tamanio = fragmentView.findViewById(R.id.xtv_facts);

        tamanio.setText("Tamaño: " + size);

        btnOtro = fragmentView.findViewById(R.id.xbtnOtro);
        btnSalir = fragmentView.findViewById(R.id.xbtnSalir);


//        TableDynamic tableDynamic = new TableDynamic(tableLayout, getContext());




        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().findViewById(R.id.secondaryLayout).setVisibility(View.VISIBLE);
                getActivity().onBackPressed();


            }
        });

        calcularMatriz( size );

        return fragmentView;


    }

    public void calcularMatriz(int size){

        int n = size; // tamaño de la matriz

        int i_ant = 0;  // variable i temporal
        int j_ant = 0; // variable j temporal

        int punto_ini = n/2; // para el primer numero.

        int[][] matriz_magica = new int [n][n]; // creo la matriz magica

        int temp = 1; // lleva la cuenta de los numeros que se van adicionando a la matriz

        //lleno la matriz de ceros
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matriz_magica[i][j] = 0;
            }
        }

        int i = 0;
        int j = punto_ini; //valor de la mitad donde empieza la matriz

        while (temp != (n*n)+1){
            if(matriz_magica[i][j] == 0) {// valido posicion vacia
                matriz_magica[i][j] = temp;
            }else{
                i = i_ant +1;
                j = j_ant;
                matriz_magica[i][j]=temp;
            }

            i_ant = i;
            j_ant = j;

            temp++;
            j++;
            i--;
            if(i<0 && j==n){ // esquina superior derecha
                i = n -1;
                j = 0;
            }else if( i < 0){ // fila -1
                i = i + n;
            }else if(j==n){ //columna igual a n
                j = 0;
            }
        }

        int suma = 0;


        for (int y = 0; y < n; y ++ ){
            TableRow fila = new TableRow(getActivity());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            fila.setLayoutParams(lp);
            suma = 0;

            for(int x = 0; x < n  ; x++){
                TextView tv = new TextView(getActivity());
                tv.setText( String.valueOf(matriz_magica[y][x]));
                suma += matriz_magica[y][x];

//                tv.setWidth(5);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(20);
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundResource(R.drawable.border_tabla);

                fila.addView(tv);
            }
            TextView resultados = new TextView(getActivity());
            resultados.setText( String.valueOf(suma));
            resultados.setGravity(Gravity.CENTER);
            resultados.setTextSize(20);
            resultados.setTextColor(Color.BLACK);
            resultados.setBackgroundResource(R.drawable.result_table_example);
            tableLayout.addView(fila, 0);
            fila.addView(resultados);

        }

        TableRow results = new TableRow(getActivity());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        results.setLayoutParams(lp);


        for (int x = 0; x < n+1; x++){

            TextView result = new TextView(getActivity());
            result.setText(String.valueOf(suma));
            result.setGravity(Gravity.CENTER);
            result.setTextSize(20);
            result.setTextColor(Color.BLACK);
            result.setBackgroundResource(R.drawable.result_table_example);
            results.addView(result);

        }
        tableLayout.addView(results);

        etSize.setText("");



    }



}