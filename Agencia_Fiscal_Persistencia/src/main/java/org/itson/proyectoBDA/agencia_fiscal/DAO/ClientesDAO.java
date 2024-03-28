package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

public class ClientesDAO implements IClientesDAO {

    final private IConexion conexion;

    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param nuevoCliente El objeto Cliente que se va a agregar.
     * @return El cliente recién agregado.
     */
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

    /**
     * Consulta un cliente en la base de datos utilizando su RFC como criterio de búsqueda.
     *
     * @param RFC El RFC del cliente que se desea consultar.
     * @return El cliente correspondiente al RFC proporcionado.
     * @throws PersistenciaException Si no se encuentra ningún cliente con el RFC proporcionado.
     */
    @Override
    public Cliente consultarCliente(String RFC) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        TypedQuery<Cliente> query = entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.RFC = :RFC",
                Cliente.class);
        query.setParameter("RFC", RFC);
        Cliente cliente = null;
        try {
            cliente = query.getSingleResult();
        } catch (NoResultException e) {
            throw new PersistenciaException("No existe un cliente con esa RFC.");
        } finally {
            entityManager.close();
        }
        return cliente;
    }
}
