
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import org.itson.proyectoBDA.agencia_fiscal.CONEXION.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Cliente;



public class ClientesDAO implements IClientesDAO{
    final private IConexion conexion;

    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(Cliente nuevoCliente) {
       EntityManager entityManager = conexion.crearConexion();
       
       entityManager.getTransaction().begin();
       entityManager.persist(nuevoCliente);
       entityManager.getTransaction().commit();
       entityManager.close();
       
       return nuevoCliente;
    }

    @Override
    public Cliente consultarCliente(String CURP) {
        EntityManager entityManager = conexion.crearConexion();
        Cliente cliente = entityManager.find(Cliente.class, CURP);
        entityManager.close();
        return cliente;
         }
    
}
