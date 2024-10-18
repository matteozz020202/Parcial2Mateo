package com.example.parcial2mateo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2mateo.adaptadores.PersonajeAdaptador;
import com.example.parcial2mateo.clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class ActividadInicio extends AppCompatActivity {

    RecyclerView rcv_items;
    List<Personaje> listaPersonajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_inicio);

        rcv_items = findViewById(R.id.rcv_items);
        rcv_items.setLayoutManager(new LinearLayoutManager(this));


        Personaje p1 = new Personaje("https://rickandmortyapi.com/api/character/avatar/1.jpeg","Rick Sanchez","Alive","Human");
        Personaje p2 = new Personaje("https://rickandmortyapi.com/api/character/avatar/2.jpeg","Morty Smith","Alive","Human");
        Personaje p3 = new Personaje("https://rickandmortyapi.com/api/character/avatar/3.jpeg","Summer Smith","Alive","Human");
        Personaje p4 = new Personaje("https://rickandmortyapi.com/api/character/avatar/4.jpeg","Beth Smith", "Alive","Human");
        Personaje p5 = new Personaje("https://rickandmortyapi.com/api/character/avatar/5.jpeg","Jerry Smith", "Alive","Human");



        listaPersonajes.add(p1);
        listaPersonajes.add(p2);
        listaPersonajes.add(p3);
        listaPersonajes.add(p4);
        listaPersonajes.add(p5);

        rcv_items.setAdapter(new PersonajeAdaptador(listaPersonajes));

    }
}