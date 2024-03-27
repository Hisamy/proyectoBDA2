
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;


public interface IRegistroPlacasBO {

    Placa registrarPlaca(PlacaDTO nuevoLicencia,ClienteDTO ClienteDTO) throws PersistenciaException;

    PlacaDTO transporteDatos(PlacaDTO nuevaPlaca, ClienteDTO ClienteDTO) throws PersistenciaException;
    
    Calendar getFechaRecepcion();
}
