package jpa.servicio;

import java.util.List;
import jpa.entidad.Fabricante;
import jpa.persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO fabricanteDAO;

    public FabricanteServicio() {
        fabricanteDAO = new FabricanteDAO();
    }

    public Fabricante crearFabricante(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre del fabricante es obligatorio");
            }

            Fabricante fabricante = new Fabricante();

            fabricante.setNombre(nombre);

            fabricanteDAO.guardarFabricante(fabricante);

            return fabricante;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void buscarFabricantes() throws Exception {
        try {
            List<Fabricante> fabricantes = fabricanteDAO.buscarFabricantes();

            imprimirFabricantes(fabricantes);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void imprimirFabricantes(List<Fabricante> fabricantes) throws Exception {
        try {
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes");
            } else {
                System.out.println("*** LISTA DE FABRICANTES ***");
                System.out.printf("%-10s%-25s\n", "CÓDIGO", "NOMBRE");
                fabricantes.forEach(f -> System.out.printf("%-10d%-25s\n", f.getCodigo(), f.getNombre()));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al imprimir fabricantes");
        }
    }
}
