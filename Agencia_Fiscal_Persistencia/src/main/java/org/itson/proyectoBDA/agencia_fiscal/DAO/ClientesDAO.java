
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import org.itson.proyectoBDA.agencia_fiscal.CONEXION.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Cliente;



public class ClientesDAO implements IClientesDAO{
    private IConexion conexion;

    public ClientesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(Cliente nuevoCliente) {
       EntityManager entityManager = conexion.crearConexion();
       
       entityManager.getTransaction().begin();
       Cliente cliente = new Cliente(
               nuevoCliente.getCURP(),
               nuevoCliente.getNombre(),
               nuevoCliente.getApellido_paterno(),
               nuevoCliente.getApellido_materno(),
               nuevoCliente.isDiscapacidad(),
               nuevoCliente.getRFC(),
               nuevoCliente.getTelefono(),
               nuevoCliente.getFecha_nacimiento()
       );
       entityManager.persist(cliente);
       entityManager.getTransaction().commit();
       entityManager.close();
       
       return cliente;
    }

    @Override
    public Cliente consultarCliente(String CURP) {
        EntityManager entityManager = conexion.crearConexion();
        Cliente cliente = entityManager.find(Cliente.class, CURP);
        entityManager.close();
        return cliente;
         }
    
}
