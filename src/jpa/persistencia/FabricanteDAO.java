package jpa.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpa.entidad.Fabricante;

public class FabricanteDAO {

    private EntityManager em = Persistence
            .createEntityManagerFactory("EjemploJPAPU")
            .createEntityManager();

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(fabricante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Error al guardar fabricante");
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(fabricante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Error al modificar fabricante");
        }
    }

    public void eliminarFabricante(Fabricante fabricante) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(fabricante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception("Error al eliminar fabricante");
        }
    }

    public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
        try {
            Fabricante fabricante = em.find(Fabricante.class, codigo);
            return fabricante;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al buscar fabricante por código");
        }
    }

    public List<Fabricante> buscarFabricantes() throws Exception {
        try {
            List<Fabricante> fabricantes = em.createQuery("SELECT f FROM Fabricante f", Fabricante.class).getResultList();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al buscar fabricantes");
        }
    }

    public List<Fabricante> buscarFabricantesPorNombre(String nombre) throws Exception {
        try {
            List<Fabricante> fabricantes = em.createQuery("SELECT f FROM Fabricante f WHERE f.nombre LIKE :nombre", Fabricante.class).setParameter("nombre", nombre).getResultList();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al buscar fabricantes por nombre");
        }
    }
}
