package com.salesianostriana.dam.di.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemStation> viajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Si tenemos claro que el layout que hemos utilizado
        // para pintar un elemento de la lista, no varía de dimensiones
        // es recomendable poner la siguiente línea de código, que
        // permite al recycler saber que las dimensiones no cambian
        // y por tanto se ahorra el tener que hacer cálculos a la
        // hora de reutilizar las vistas
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        viajes = new ArrayList();
        viajes.add(new ItemStation("Ciudad Expo","Spain",R.drawable.giralda,5));
        viajes.add(new ItemStation("Cavaleri","Spain",R.drawable.giralda,5));
        viajes.add(new ItemStation("San Juan Alto","Spain",R.drawable.giralda,4));
        viajes.add(new ItemStation("San Juan Bajo","Spain",R.drawable.giralda,5));
        viajes.add(new ItemStation("Blas Infante","Spain",R.drawable.giralda,1));
        viajes.add(new ItemStation("Parque de los Príncipes","Spain",R.drawable.giralda,3));
        viajes.add(new ItemStation("Plaza de Cuba","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Puerta de Jerez","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Prado de San Sebastián","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("San Bernardo","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Nervión","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Gran Plaza","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("1º de Mayo","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Amate","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("La Plata","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Cocheras","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Guadaíra","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Pablo de Olavide","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Condequinto","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Montequinto","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Europa","Spain",R.drawable.giralda,2));
        viajes.add(new ItemStation("Olivar de Quintos","Spain",R.drawable.giralda,2));
















        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(viajes);
        mRecyclerView.setAdapter(mAdapter);

    }
}
