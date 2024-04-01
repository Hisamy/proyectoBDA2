package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;

public class TramitesDAO implements ITramitesDAO {

    private final IConexion conexion;

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
        List<Tramite> historialTramites = null;

        Query query = entityManager.createQuery("SELECT t FROM Tramite t");
        historialTramites = query.getResultList();

        return historialTramites;
    }
}
