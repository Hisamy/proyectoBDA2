
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;


public class TramitesDAO implements ITramitesDAO {

    private final IConexion conexion;

    public TramitesDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Tramite> consultarTramites() {
        EntityManager entityManager = conexion.crearConexion();
        List<Object[]>  consultas= null;
        List<Tramite> historialTramites = new ArrayList<>();
        
        Query query  = entityManager.createQuery("SELECT t.tipo, t.costo, t.fecha_expedicion FROM tramites t");
        consultas = query.getResultList();
        
        for(Object[] consulta : consultas){
            String tipo = (String) consulta[0];
            Float costo = (Float) consulta[1];
            Calendar fechaExpedicion = (Calendar) consulta[2];
            Cliente cliente = (Cliente) consulta[3];
            
            Tramite tramite = new Tramite();
            tramite.setCliente(cliente);
            tramite.setCosto(costo);
            tramite.setFecha_expedicion(fechaExpedicion);
            //Tipo no sale por el discriminator
            
            historialTramites.add(tramite);
        }
        
        return historialTramites;
        
        
         
        
       
        } 
    
}
