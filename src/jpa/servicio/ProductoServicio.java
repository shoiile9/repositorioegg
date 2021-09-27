package jpa.servicio;

import java.util.List;
import jpa.entidad.Fabricante;
import jpa.entidad.Producto;
import jpa.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO productoDAO;
    private FabricanteServicio fabricanteServicio;

    public ProductoServicio() {
        productoDAO = new ProductoDAO();
        fabricanteServicio = new FabricanteServicio();
    }

    public void crearProducto(String nombre, Double precio, String nombreFabricante) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }

            if (precio == null) {
                throw new Exception("El precio es obligatorio");
            }

            if (nombreFabricante == null || nombreFabricante.trim().isEmpty()) {
                throw new Exception("El nombre del fabricante es obligatorio");
            }

            Fabricante fabricante = fabricanteServicio.crearFabricante(nombreFabricante);

            Producto producto = new Producto();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(fabricante);

            productoDAO.guardarProducto(producto);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {
        try {
            List<Producto> productos = productoDAO.buscarProductos();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-10s%-25s%-15s%-25s%-25s\n", "CÓDIGO", "NOMBRE", "PRECIO", "CÓDIGO DE FABRICANTE", "FABRICANTE");
                productos.forEach(p -> System.out.printf("%-10d%-25s%-15s%-25d%-25s\n", p.getCodigo(), p.getNombre(), p.getPrecio(), p.getFabricante().getCodigo(), p.getFabricante().getNombre()));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir productos");
        }
    }
}
