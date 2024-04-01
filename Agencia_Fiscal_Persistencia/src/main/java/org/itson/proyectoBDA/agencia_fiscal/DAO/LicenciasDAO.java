package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;

public class LicenciasDAO implements ILicenciasDAO {

    final private IConexion conexion;

    public LicenciasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta los datos de la licencia asociada a un cliente.
     *
     * @param cliente El cliente cuya licencia se desea consultar.
     * @return La licencia asociada al cliente.
     */
    @Override
    public Licencia consultarDatosLicencia(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();
        System.out.println(cliente.toString());
        TypedQuery<Licencia> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente", Licencia.class);
        query.setParameter("cliente", cliente);
        Licencia licencia = query.getSingleResult();

        entityManager.close();

        return licencia;
    }

    /**
     * Consulta los datos de la última licencia emitida para un cliente.
     *
     * @param cliente El cliente cuya última licencia se desea consultar.
     * @return La última licencia emitida para el cliente.
     */
    @Override
    public Licencia consultarDatosUltimaLicencia(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();

        TypedQuery<Licencia> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente AND l.estado = true", Licencia.class);
        query.setParameter("cliente", cliente);
        query.setMaxResults(1); // Obtener solo el primer resultado, que sería el más reciente
        Licencia licencia = query.getSingleResult();

        entityManager.close();

        return licencia;
    }

    /**
     * Agrega una nueva licencia a la base de datos.
     *
     * @param nuevaLicencia La nueva licencia a agregar.
     * @return La licencia agregada.
     */
    @Override
    public Licencia agregarLicencia(Licencia nuevaLicencia) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevaLicencia);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevaLicencia;
    }

    /**
     * Actualiza los datos de una licencia en la base de datos.
     *
     * @param licenciaActualizada La licencia con los datos actualizados.
     * @return La licencia actualizada.
     */
    @Override
    public Licencia actualizarLicencia(Licencia licenciaActualizada) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        Licencia licenciaPersistida = entityManager.merge(licenciaActualizada);
        entityManager.getTransaction().commit();
        entityManager.close();

        return licenciaPersistida;
    }
}
