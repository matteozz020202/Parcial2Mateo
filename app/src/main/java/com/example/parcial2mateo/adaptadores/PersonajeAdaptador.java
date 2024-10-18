package com.example.parcial2mateo.adaptadores;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2mateo.ActividadDetalle;
import com.example.parcial2mateo.R;
import com.example.parcial2mateo.clases.Personaje;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdaptador extends RecyclerView.Adapter<PersonajeAdaptador.ViewHolder> {

    private List<Personaje> datos;

    public PersonajeAdaptador(List<Personaje> datos) {
        this.datos = datos;
    }


    @NonNull
    @Override
    public PersonajeAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdaptador.ViewHolder holder, int position) {
        Personaje dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nombre, txt_estado, txt_especie;
        ImageView img_avatar;
        Button btn_see;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Encontrar los elementos del XML por id
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_estado = itemView.findViewById(R.id.txt_estado);
            txt_especie = itemView.findViewById(R.id.txt_especie);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            btn_see = itemView.findViewById(R.id.btn_see);

        }

        public void bind(Personaje dato) {
            txt_nombre.setText(dato.getNombre());
            txt_especie.setText(dato.getEspecie());
            txt_estado.setText(dato.getEstado());

            // Cambiar el color del botón según el estado
            cambiarColorBotonSegunEstado(txt_estado, dato.getEstado());


            // Establecer la imagen de la tarea con Picasso
            Picasso.get().load(dato.getImagen()).into(img_avatar);

            // Al hacer clic en el item
            btn_see.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    Gson gson = new Gson();

                    bundle.putString("personaje", gson.toJson(dato));

                    Intent i = new Intent(itemView.getContext(), ActividadDetalle.class);
                    i.putExtras(bundle);

                    itemView.getContext().startActivity(i);
                }
            });
        }
        private void cambiarColorBotonSegunEstado(TextView txt_estado, String estadoPersonaje) {
            int color;
            // Obtener el contexto del itemView
            View itemView = txt_estado.getRootView();
            switch (estadoPersonaje) {
                case "Alive":
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.holo_green_dark);  // Color verde
                    break;
                case "Dead":
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.holo_red_dark);    // Color rojo
                    break;
                default:
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.darker_gray);   // Color gris
                    break;
            }
            // Cambiar el color del botón
            txt_estado.setTextColor(ColorStateList.valueOf(color));
        }
    }
}


