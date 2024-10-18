package com.example.parcial2mateo.clases;

public class Personaje {
    String imagen,nombre,estado,especie;

    public Personaje(String imagen, String nombre, String estado, String especie) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
