/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public VehiculosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo nuevoVehiculo) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevoVehiculo);
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
        return nuevoVehiculo;
    }

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
