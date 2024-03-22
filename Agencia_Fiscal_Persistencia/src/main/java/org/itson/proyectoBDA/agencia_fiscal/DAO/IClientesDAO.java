package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;

public interface IClientesDAO {

    public Cliente agregarCliente(Cliente nuevoCliente);

    public Cliente consultarCliente(String RFC);
}
