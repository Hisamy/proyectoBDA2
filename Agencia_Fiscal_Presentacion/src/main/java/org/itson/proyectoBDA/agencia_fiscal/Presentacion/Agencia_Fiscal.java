package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;

public class Agencia_Fiscal {

    public static IConexion conexion;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Crear clientes
        Cliente cliente1 = new Cliente(
                "TARE040818HSRLMDA1",
                "Eduardo",
                "Talavera",
                "Ramos",
                true,
                "RETADGAG12344",
                "6442261760",
                new GregorianCalendar(2004, 8, 18));

        Cliente cliente2 = new Cliente(
                "CICH191004HSRLMDA",
                "Hisamy",
                "Cinco",
                "Cota",
                false,
                "HOLA1234",
                "6871699800",
                new GregorianCalendar(2004, 10, 19));

        Cliente cliente3 = new Cliente(
                "CAMG040802",
                "Gael",
                "Catro",
                "Molina",
                true,
                "GETO18921",
                "6441699800",
                new GregorianCalendar(2004, 8, 02));

        Cliente cliente4 = new Cliente(
                "CAMG040802",
                "Gael",
                "Catro",
                "Molina",
                true,
                "GETO18921",
                "6441699800",
                new GregorianCalendar(2004, 8, 02));

        Cliente cliente5 = new Cliente(
                "VEBV040902",
                "Victoria",
                "Vega",
                "Bernal",
                true,
                "MIKU09211",
                "6871741035",
                new GregorianCalendar(2004, 9, 02));

        Cliente cliente6 = new Cliente(
                "CICA120412",
                "Angel",
                "Cinco",
                "Cota",
                false,
                "BEIS0983211",
                "687211913",
                new GregorianCalendar(2012, 4, 12));

        Vehiculo vehiculo1 = new Vehiculo("num_serie", 1920, "Rojo", "Chevrolet", "Sierra", true);

//        entityManager.persist(vehiculo1);
//        entityManager.persist(cliente1);
//        entityManager.persist(cliente2);
//        entityManager.persist(cliente3);
//        entityManager.persist(cliente4);
//        entityManager.persist(cliente5);
//        entityManager.persist(cliente6);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        BuscarCliente buscarCliente = new BuscarCliente();
        buscarCliente.setVisible(true);
    }
}
