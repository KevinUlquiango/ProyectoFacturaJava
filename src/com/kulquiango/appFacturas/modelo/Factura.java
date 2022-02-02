package com.kulquiango.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Factura {
    private int folio; /*Id de factura*/
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceIntems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;


    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceIntems < MAX_ITEMS) {
            this.items[indiceIntems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            /*if (!(item instanceof  ItemFactura)){
                continue;
            }*/
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder contenar = new StringBuilder("Factura N°: ");
        contenar.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\nNif: ")
                .append(this.cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        contenar.append("Fecha emision: ")
                .append(formatoFecha.format(this.fecha))
                .append(" \n#\tNombre\t$Cant.\tTotal\n")
                .append("\n");
        int contador = 0;
        for (ItemFactura item : this.items) {

            if (item == null) {
                contador++;
                continue;
            }

            contenar.append(item)
                    .append("\n");
        }
        /*
        Este contador es para ver las veces que se uso el continue
        ya que el array tiene un tamaño de 12 pero en el for solo de itera hasta 5
        */
        System.out.println(contador);
        contenar.append("\nGran total: ")
                .append(calcularTotal());

        return contenar.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
