package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoNuevoDTO;

public interface IRegistroVehiculosBO {

    Vehiculo registrarVehiculo(VehiculoNuevoDTO nuevoVehiculo) throws PersistenciaException;

    VehiculoNuevoDTO transporteDatos(VehiculoNuevoDTO nuevoVehiculo);
}
