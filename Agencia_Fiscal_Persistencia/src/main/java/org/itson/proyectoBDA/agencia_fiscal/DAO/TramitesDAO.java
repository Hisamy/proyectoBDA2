package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

/**
 *
 * @author Ramosz
 */
public class TramitesDAO implements ITramitesDAO {

    private final IConexion conexion;

    /**
     *
     * @param conexion
     */
    public TramitesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta todos los trámites almacenados en la base de datos.
     *
     * @return Una lista de trámites.
     * @throws FindException Si ocurre un error al consultar los trámites.
     */
    @Override
    public List<Tramite> consultarTramites() throws FindException {
        EntityManager entityManager = conexion.crearConexion();
        List<Object[]> consultas = null;
        List<Tramite> historialTramites = new ArrayList<>(); // Inicializar la lista

        Query query = entityManager.createQuery("SELECT t.tipo_tramite, t.costo, t.estado, t.fecha_emision, t.fecha_expedicion, t.cliente FROM Tramite t"); // Modificar la consulta para seleccionar los campos específicos que necesitas
        try {
            consultas = query.getResultList();

            for (Object[] consulta : consultas) {
                String tipo_tramite = (String) consulta[0]; // Obtener la fecha de emisión como Calendar
                float costo = (float) consulta[1]; // Obtener el costo como float
                boolean estado = (boolean) consulta[2]; // Obtener el estado como String
                Calendar fecha_emision = (Calendar) consulta[3]; // Obtener la fecha de emisión como Calendar
                Calendar fecha_expedicion = (Calendar) consulta[4]; // Obtener la fecha de expedición como Calendar
                Cliente cliente = (Cliente) consulta[5]; // Obtener la fecha de expedición como Calendar

                Tramite tramite = new Tramite();
                tramite.setTipo_tramite(tipo_tramite);
                tramite.setCosto(costo);
                tramite.setEstado(estado);
                tramite.setFecha_emision(fecha_emision);
                tramite.setFecha_expedicion(fecha_expedicion);
                tramite.setCliente(cliente);

                historialTramites.add(tramite); // Agregar el trámite a la lista
            }
        } catch (NoResultException ex) {
            throw new FindException("No existe ningún trámite registrado.");
        } finally {
            entityManager.close();
        }
        return historialTramites;
    }

    /**
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    @Override
    public List<Tramite> consultarTramitesPorCliente(List<Cliente> cliente) throws FindException {
        EntityManager entityManager = conexion.crearConexion();
        List<Tramite> tramites = new ArrayList<>();

        Query query = entityManager.createQuery("SELECT t FROM Tramite t WHERE t.cliente = :cliente");
        query.setParameter("cliente", cliente);

        try {
            tramites = query.getResultList();
        } catch (NoResultException ex) {
            throw new FindException("No se encontraron trámites para el cliente especificado.");
        } finally {
            entityManager.close();
        }

        return tramites;
    }

}
