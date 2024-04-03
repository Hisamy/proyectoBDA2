package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;

/**
 * Clase principal de la aplicación Agencia_Fiscal. Esta clase realiza la inicialización de la base de datos, crea algunos clientes y vehículos de prueba, y muestra la ventana principal de la aplicación.
 *
 * @author Eduardo Talavera, Hisamy Cinco
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
