package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public interface IRegistroPlacasBO {

    Placa registrarPlaca(PlacaDTO nuevaPlaca, ClienteDTO clienteDTO, Vehiculo vehiculo) throws PersistenciaException;

    PlacaDTO transporteDatos(PlacaDTO nuevaPlaca, ClienteDTO ClienteDTO) throws PersistenciaException;

    VehiculoDTO conversorVehiculoDTO(PlacaDTO nuevaPlaca, ClienteDTO clienteDTO) throws PersistenciaException;

    Calendar getFechaRecepcion();
}
