package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;

public interface IClientesDAO {

    public Cliente agregarCliente(Cliente nuevoCliente);

    public Cliente consultarCliente(String RFC) throws PersistenciaException;
}
