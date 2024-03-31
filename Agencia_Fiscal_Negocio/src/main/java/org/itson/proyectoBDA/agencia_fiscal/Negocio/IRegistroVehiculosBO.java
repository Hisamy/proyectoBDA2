package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public interface IRegistroVehiculosBO {

    Vehiculo registrarVehiculo(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    VehiculoDTO transporteDatos(VehiculoDTO nuevoVehiculo) throws PersistenciaException;

    Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException;
}
