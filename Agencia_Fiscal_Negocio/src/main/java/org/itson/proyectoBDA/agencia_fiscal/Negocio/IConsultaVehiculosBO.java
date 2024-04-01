package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

/**
 *
 * @author Ramosz
 */
public interface IConsultaVehiculosBO {

    /**
     *
     * @param numero_serie
     * @return
     * @throws FindException
     */
    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException;

    /**
     *
     * @param vehiculo
     * @return
     * @throws FindException
     */
    public VehiculoDTO regresaVehiculoConsultado(Vehiculo vehiculo) throws FindException;

    /**
     *
     * @param numero_serie
     * @return
     * @throws FindException
     */
    public VehiculoDTO transporteDatos(String numero_serie) throws FindException;

}
