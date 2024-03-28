package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IVehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.VehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class ConsultaVehiculosBO implements IConsultaVehiculosBO {

    private final IVehiculosDAO vehiculoDAO;

    public ConsultaVehiculosBO() {
        IConexion conexion = new Conexion();
        this.vehiculoDAO = new VehiculosDAO(conexion);
    }

    /**
     * Método que consulta con el numero de serie el vehiculo si existe en la
     * base de datos.
     *
     * @param numero_serie numero de serie del vehículo
     * @return el vehiculo registrado.
     * @throws FindException Si ocurre un error al recuperar el vehiculo con el
     * numero de serie.
     */
    @Override
    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException {
        try {
            Vehiculo vehiculo = vehiculoDAO.consultarVehiculo(numero_serie);
            regresaVehiculoConsultado(vehiculo);
            Vehiculo getVehiculo = new Vehiculo(
                    vehiculo.getNumero_serie(),
                    vehiculo.getModelo(),
                    vehiculo.getColor(),
                    vehiculo.getMarca(),
                    vehiculo.getLinea(),
                    vehiculo.isLicencia_vigente());
            return getVehiculo;
        } catch (PersistenciaException e) {
            throw new FindException(e.getMessage());
        }
    }

    /**
     * Recupera un objeto VehiculoDTO basado en el número de serie del vehículo.
     *
     * @param vehiculo El objeto Vehiculo que contiene el número de serie a
     * buscar.
     * @return Un objeto VehiculoDTO que contiene información sobre el vehículo
     * con el número de serie especificado.
     * @throws FindException Si ocurre un error al recuperar el objeto
     * VehiculoDTO.
     */
    @Override
    public VehiculoDTO regresaVehiculoConsultado(Vehiculo vehiculo) throws FindException {
        VehiculoDTO vehiculoDTO = new VehiculoDTO(
                vehiculo.getNumero_serie(),
                vehiculo.getModelo(),
                vehiculo.getColor(),
                vehiculo.getMarca(),
                vehiculo.getLinea(),
                vehiculo.isLicencia_vigente());
        return vehiculoDTO;
    }

    /**
     * Recupera un objeto VehiculoDTO basado en el número de serie del vehículo.
     * Este método actúa como una capa de transporte para obtener datos del
     * vehículo basados en el número de serie.
     *
     * @param numero_serie El número de serie del vehículo del cual se desea
     * obtener los datos.
     * @return Un objeto VehiculoDTO que contiene información sobre el vehículo
     * con el número de serie especificado.
     * @throws FindException Si ocurre un error mientras se recupera el objeto
     * VehiculoDTO.
     */
    @Override
    public Boolean transporteDatos(String numero_serie) throws FindException {
        Vehiculo vehiculo = consultarVehiculoNumSerie(numero_serie);
        if (vehiculo != null) {
            return true;
        } else {
            return false;
        }

    }
}
