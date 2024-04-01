package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

/**
 *
 * @author Ramosz
 */
public class VehiculosDAO implements IVehiculosDAO {

    final private IConexion conexion;

    /**
     *
     * @param conexion
     */
    public VehiculosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo vehículo a la base de datos.
     *
     * @param nuevoVehiculo El vehículo a agregar.
     * @return El vehículo agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * del vehículo.
     */
    @Override
    public Vehiculo agregarVehiculo(Vehiculo nuevoVehiculo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevoVehiculo);
        entityManager.getTransaction().commit();
        nuevoVehiculo = consultarVehiculo(nuevoVehiculo.getNumero_serie());
        entityManager.close();

        return nuevoVehiculo;
    }

    /**
     * Consulta un vehículo por su número de serie.
     *
     * @param numero_serie El número de serie del vehículo a consultar.
     * @return El vehículo encontrado.
     * @throws PersistenciaException Si no se encuentra ningún vehículo con el
     * número de serie especificado.
     */
    @Override
    public Vehiculo consultarVehiculo(String numero_serie) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        TypedQuery<Vehiculo> query = entityManager.createQuery(
                "SELECT v FROM Vehiculo v WHERE v.numero_serie = :numero_serie",
                Vehiculo.class);
        query.setParameter("numero_serie", numero_serie);
        Vehiculo vehiculo = null;
        try {
            vehiculo = query.getSingleResult();
        } catch (NoResultException e) {
            throw new PersistenciaException("No existe un vehículo con ese número de serie.");
        } finally {
            entityManager.close();
        }
        return vehiculo;
    }
}
