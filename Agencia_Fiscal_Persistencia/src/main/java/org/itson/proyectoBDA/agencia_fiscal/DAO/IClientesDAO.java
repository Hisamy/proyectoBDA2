package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.Calendar;
import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

/**
 *
 * @author Ramosz
 */
public interface IClientesDAO {

    /**
     *
     * @param nuevoCliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente agregarCliente(Cliente nuevoCliente) throws PersistenciaException;

    /**
     *
     * @param RFC
     * @return
     * @throws PersistenciaException
     */
    public Cliente consultarClienteRFC(String RFC) throws PersistenciaException;
    
    /**
     *
     * @return
     * @throws FindException
     */
    public List<Cliente> historialClientes()throws FindException;
    
    /**
     *
     * @param nombre_apellido
     * @return
     * @throws FindException
     */
    public List<Cliente> consultarClientePorNombre(String nombre_apellido) throws FindException;
    
    /**
     *
     * @param anioNacimiento
     * @return
     * @throws FindException
     */
    public List<Cliente> consultarClientePorAnioNacimiento(int anioNacimiento) throws FindException;
}
