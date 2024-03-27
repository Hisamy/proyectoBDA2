
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import static org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite_.id;



public class PlacasDAO implements IPlacasDAO {

    final private IConexion conexion;

    public PlacasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Placa agregarLicencia(Placa nuevaPlaca) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevaPlaca);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevaPlaca;
    }

    @Override
    public Placa consultarDatosPlaca() {
        EntityManager entityManager = conexion.crearConexion();
        Placa placa = entityManager.find(Placa.class,id );
        entityManager.close();
        return placa;
    }
}
