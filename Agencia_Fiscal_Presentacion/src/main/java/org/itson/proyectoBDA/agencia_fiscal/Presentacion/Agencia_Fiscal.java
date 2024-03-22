package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistroClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.RegistroClientesBO;

public class Agencia_Fiscal {

    public static IConexion conexion;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        IRegistroClientesBO registroClientesBO = new RegistroClientesBO();
        RegistrarCliente registrarCliente = new RegistrarCliente(registroClientesBO);
        registrarCliente.setVisible(true);
    }
}
