package com.tintobendito.etb;

public class PojoProducto {

    //Características del Objeto
    private int foto;
    private String nomProducto;
    private String precProducto;

    public PojoProducto() {
    }

    public PojoProducto(int foto, String nomProducto, String precProducto) {
        this.foto = foto;
        this.nomProducto = nomProducto;
        this.precProducto = precProducto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getPrecProducto() {
        return precProducto;
    }

    public void setPrecProducto(String precProducto) {
        this.precProducto = precProducto;
    }
}
