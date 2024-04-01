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

    @Override
    public List<Tramite> consultarTramites() throws FindException {
//        EntityManager entityManager = conexion.crearConexion();
//        List<Object[]> consultas = null;
//        List<Tramite> historialTramites = new ArrayList<>();
//
//        Query query = entityManager.createQuery("SELECT t.tipo, t.costo, t.estado, t.fecha_emision, t.fecha_expedicion FROM Tramite t");
//        consultas = query.getResultList();
//
//        for (Object[] consulta : consultas) {
//            String tipo = (String) consulta[0];
//            Float costo = (Float) consulta[1];
//            boolean estado = (boolean) consulta[2];
//            Calendar fechaEmision = (Calendar) consulta[3];
//            Calendar fechaExpedicion = (Calendar) consulta[4];
//            Cliente cliente = (Cliente) consulta[5];
//
//            Tramite tramite = new Tramite();
//            tramite.setTipo_tramite(tipo);
//            tramite.setCosto(costo);
//            tramite.setEstado(estado);
//            tramite.setFecha_emision(fechaEmision);
//            tramite.setFecha_expedicion(fechaExpedicion);
//            tramite.setCliente(cliente);
//
//            historialTramites.add(tramite);
//        }
//        return historialTramites;
        EntityManager entityManager = conexion.crearConexion();
        List<Tramite> historialTramites = null;

        Query query = entityManager.createQuery("SELECT t FROM Tramite t");
        historialTramites = query.getResultList();

        return historialTramites;
    }
}
