package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.ConsultaClientesBO;
import org.itson.proyectoBDA.agencia_fiscal.Negocio.IConsultaClientesBO;

public class Agencia_Fiscal {

    public static IConexion conexion;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        Calendar fecha = new GregorianCalendar(2004, 8, 18);

        Cliente clienteNuevo = new Cliente("TARE040818HSRLMDA1", "Eduardo", "Talavera", "Ramos", true, "RETADGAG12344", "6442261760", fecha);

//        IRegistroClientesBO registraClientes = new RegistroClientesBO();
//        RegistrarCliente registraCliente = new RegistrarCliente(registraClientes);
        IConsultaClientesBO consultaClientes = new ConsultaClientesBO();
        BuscarCliente buscarCliente = new BuscarCliente(consultaClientes);
        buscarCliente.setVisible(true);
    }
}
