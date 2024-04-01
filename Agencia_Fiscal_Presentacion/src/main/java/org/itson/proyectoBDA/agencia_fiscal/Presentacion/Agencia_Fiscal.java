package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;

/**
 * Clase principal de la aplicación Agencia_Fiscal. Esta clase realiza la inicialización de la base de datos, crea algunos clientes y vehículos de prueba, y muestra la ventana principal de la aplicación.
 *
 * @author Ramosz
 */
public class Agencia_Fiscal {

    /**
     * Objeto para la conexión a la base de datos.
     */
    public static IConexion conexion;

    /**
     * Método principal de la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {

        // Inicialización del EntityManagerFactory y EntityManager para la base de datos
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Agencia_Fiscal_PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Crear clientes de prueba
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
                "VEBV040902",
                "Victoria",
                "Vega",
                "Bernal",
                true,
                "MIKU09211",
                "6871741035",
                new GregorianCalendar(2004, 9, 02));

        Cliente cliente5 = new Cliente(
                "CICA120412",
                "Angel",
                "Cinco",
                "Cota",
                false,
                "BEIS0983211",
                "687211913",
                new GregorianCalendar(2012, 4, 12));

        // Crear un vehículo de prueba
        Vehiculo vehiculo1 = new Vehiculo("num_serie", "tipo", 1998, "color", "marca", "linea", true);

        // Confirmar las transacciones en la base de datos
        entityManager.getTransaction().commit();

        // Cerrar el EntityManager y EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        // Mostrar la ventana principal de la aplicación
        Index index = new Index();
        index.setVisible(true);
    }
}
