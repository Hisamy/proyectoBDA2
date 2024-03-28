package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public interface IConsultaVehiculosBO {

    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException;

    public Boolean transporteDatos(String numero_serie) throws FindException;

    public VehiculoDTO regresaVehiculoConsultado (Vehiculo vehiculo) throws FindException;
    
    
}
