package com.tintobendito.etb.modelos;

public class Usuario {

    private String id;
    private String nombre;
    private String correo;
    private long tiempo;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String correo, long tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
}
