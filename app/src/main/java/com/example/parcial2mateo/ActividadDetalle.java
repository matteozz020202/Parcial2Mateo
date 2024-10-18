package com.example.parcial2mateo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parcial2mateo.clases.Personaje;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ActividadDetalle extends AppCompatActivity {

    ImageView img_detalle;
    TextView txt_nombre_detalle,txt_estado_detalle,txt_especie_detalle;
    Button btn_volver;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUserCache = "dataUser";
    private static final int modo_pivate = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_detalle);

        txt_nombre_detalle = findViewById(R.id.txt_nombre_detalle);
        txt_estado_detalle = findViewById(R.id.txt_estado_detalle);
        txt_especie_detalle = findViewById(R.id.txt_especie_detalle);
        img_detalle = findViewById(R.id.img_detalle);
        btn_volver = findViewById(R.id.btn_volver);


        sharedPreferences = getSharedPreferences(dataUserCache,modo_pivate);
        editor =sharedPreferences.edit();


        Bundle b = getIntent().getExtras();
        Gson gson = new Gson();
        Personaje personaje = gson.fromJson(b.getString("personaje"), Personaje.class);

        txt_nombre_detalle.setText(personaje.getNombre());
        txt_estado_detalle.setText(personaje.getEstado());
        txt_especie_detalle.setText(personaje.getEspecie());

        Picasso.get().load(personaje.getImagen()).into(img_detalle);


        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                Intent i = new Intent(ActividadDetalle.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}