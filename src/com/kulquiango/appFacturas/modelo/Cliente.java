package com.kulquiango.appFacturas.modelo;

public class Cliente {
    private String nombre;
    private String nif; /*Numero de identificacion tributaria*/

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
