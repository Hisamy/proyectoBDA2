package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IRegistro_ClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.Registro_ClientesBO;

public class Agencia_Fiscal {

    public static IConexion conexion;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        IRegistro_ClientesBO registroClientesBO = new Registro_ClientesBO();
        RegistrarCliente registrarCliente = new RegistrarCliente(registroClientesBO);
        registrarCliente.setVisible(true);
    }
}
