package jpa;

import jpa.servicio.FabricanteServicio;
import jpa.servicio.ProductoServicio;

public class Principal {

    public static void main(String[] args) {
        ProductoServicio productoServicio = new ProductoServicio();
        FabricanteServicio fabricanteServicio = new FabricanteServicio();

        try {
//            productoServicio.crearProducto("Guitar Les Paul", 130000.55, "Gibson");
//            productoServicio.crearProducto("Amplificador Crush", 80000.55, "Orange");
//            productoServicio.crearProducto("Guitar Stratocaster", 110000.55, "Fender");
            productoServicio.imprimirProductos();
            fabricanteServicio.buscarFabricantes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
