package jpa.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpa.entidad.Producto;

public class ProductoDAO {

    private EntityManager em = Persistence
            .createEntityManagerFactory("EjemploJPAPU")
            .createEntityManager();

    public void guardarProducto(Producto producto) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al guardar producto");
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al modificar producto");
        }
    }

    public void eliminarProducto(Producto producto) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar producto");
        }
    }

    public List<Producto> buscarProductos() throws Exception {
        try {
            List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al buscar productos");
        }
    }
}
