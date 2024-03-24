package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;

public class ClientesDAO implements IClientesDAO {

    final private IConexion conexion;

    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(Cliente nuevoCliente) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevoCliente);
        entityManager.getTransaction().commit();
        entityManager.close();

//        List<Tramite> licencias = new ArrayList<>();
//        nuevoCliente.getTramites().forEach(licencia -> {
//            licencias.add(
//                    new Licencia()
//                    )
//                    )
//            );
//        });
        return nuevoCliente;
    }

    @Override
    public Cliente consultarCliente(String RFC) {
        EntityManager entityManager = conexion.crearConexion();
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.RFC = :RFC", Cliente.class);
        query.setParameter("RFC", RFC);
        Cliente cliente = null;
        try {
            cliente = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No Cliente found for RFC: " + RFC);
        } finally {
            entityManager.close();
        }
        return cliente;
    }
}
