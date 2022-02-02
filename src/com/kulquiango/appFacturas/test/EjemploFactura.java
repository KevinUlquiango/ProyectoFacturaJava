package com.kulquiango.appFacturas.test;

import com.kulquiango.appFacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("1233");
        cliente.setNombre("Kevin");

        Scanner inputData = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        String descripcion = inputData.nextLine();
        Factura factura = new Factura(descripcion, cliente);

        Producto producto;
        /*String nombre;
        Float precio;
        int cantidad;*/

        System.out.println();
        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(inputData.nextLine());

            System.out.println("Ingrese Precio: ");
            producto.setPrecio(inputData.nextFloat());

            System.out.println("Ingrese la cantidad: ");

            factura.addItemFactura(new ItemFactura(inputData.nextInt(),producto));
            System.out.println();
            inputData.nextLine();
        }
        System.out.println(factura);
    }
}
