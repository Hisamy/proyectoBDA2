package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;

public class Agencia_Fiscal {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        
        IConexion conexion = new Conexion(); 
        RegistrarCliente registrarCliente = new RegistrarCliente(conexion);
        registrarCliente.setVisible(true);
        

    }

}
