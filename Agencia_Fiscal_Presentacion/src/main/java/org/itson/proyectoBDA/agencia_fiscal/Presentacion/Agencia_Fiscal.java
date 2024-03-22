package org.itson.proyectoBDA.agencia_fiscal.Presentacion;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
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
        LocalDate fechaActual = LocalDate.now();

       

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


    
//        IRegistroClientesBO registraClientes = new RegistroClientesBO();
//        RegistrarCliente registraCliente = new RegistrarCliente(registraClientes);
        IConsultaClientesBO consultaClientes = new ConsultaClientesBO();
        BuscarCliente buscarCliente = new BuscarCliente(consultaClientes);
        buscarCliente.setVisible(true);
    }
}
