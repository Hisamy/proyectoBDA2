package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.Calendar;
import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

public interface IClientesDAO {

    public Cliente agregarCliente(Cliente nuevoCliente) throws PersistenciaException;

    public Cliente consultarClienteRFC(String RFC) throws PersistenciaException;
    
    public List<Cliente> historialClientes()throws FindException;
    
    public List<Cliente> consultarClientePorNombre(String nombre_apellido) throws FindException;
    
     public List<Cliente> consultarClientePorAnioNacimiento(int anioNacimiento) throws FindException;
}
