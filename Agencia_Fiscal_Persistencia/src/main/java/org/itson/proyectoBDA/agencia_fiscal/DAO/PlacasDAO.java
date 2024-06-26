package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public class PlacasDAO implements IPlacasDAO {

    final private IConexion conexion;

    /**
     *
     * @param conexion
     */
    public PlacasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta los datos de la placa asociada a un cliente.
     *
     * @param cliente El cliente cuya placa se va a consultar.
     * @return La placa asociada al cliente.
     */
    @Override
    public Placa consultarDatosPlaca(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();
        TypedQuery<Placa> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente", Placa.class);
        query.setParameter("cliente", cliente);
        Placa placa = query.getSingleResult();

        entityManager.close();
        return placa;
    }

    /**
     * Consulta la última placa activa asociada a un cliente en particular.
     *
     * @param cliente El cliente para el cual se desea consultar la última placa
     * activa.
     * @return La última placa activa asociada al cliente especificado.
     */
    @Override
    public Placa consultarDatosUltimaLicencia(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();

        TypedQuery<Placa> query = entityManager.createQuery(
                "SELECT l FROM Placa l WHERE l.cliente = :cliente AND l.estado = true", Placa.class);
        query.setParameter("cliente", cliente);
        query.setMaxResults(1); // Obtener solo el primer resultado, que sería el más reciente
        Placa placa = query.getSingleResult();

        entityManager.close();

        return placa;
    }

    /**
     * Agrega una nueva placa a la base de datos.
     *
     * @param nuevaPlaca La nueva placa que se va a agregar.
     * @return La placa agregada.
     */
    @Override
    public Placa agregarPlaca(Placa nuevaPlaca) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.merge(nuevaPlaca);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevaPlaca;
    }

    /**
     * Actualiza los datos de una placa en la base de datos.
     *
     * @param placaActualizada La placa con los datos actualizados.
     * @return La placa actualizada.
     */
    @Override
    public Placa actualizarPlaca(Placa placaActualizada) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        Placa placaPersistida = entityManager.merge(placaActualizada);
        entityManager.getTransaction().commit();
        entityManager.close();

        return placaPersistida;
    }

    @Override
    public boolean validarPlaca(String numero_alfanumerico) {
     EntityManager entityManager = conexion.crearConexion();    
      try {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(p) FROM Placa p WHERE p.numero_alfanumerico = :numero_alfanumerico",
                    Long.class);
            query.setParameter("numero_alfanumerico", numero_alfanumerico);

            Long count = query.getSingleResult();

         return count != 0;
        } finally {
            entityManager.close();
        }
    }
}
