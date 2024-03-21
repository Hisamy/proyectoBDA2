
package org.itson.proyectoBDA.agencia_fiscal.Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexion implements IConexion{

    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
      }
    
}
