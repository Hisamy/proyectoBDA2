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

    @Override
    public Vehiculo consultarVehiculoNumSerie(String numero_serie) throws FindException {
        try {
            Vehiculo vehiculo = vehiculoDAO.consultarVehiculo(numero_serie);
            consultarVehiculoDTONumSerie(vehiculo);
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

    @Override
    public VehiculoDTO consultarVehiculoDTONumSerie(Vehiculo vehiculo) throws FindException {
        VehiculoDTO vehiculoDTO = new VehiculoDTO(
                vehiculo.getNumero_serie(),
                vehiculo.getModelo(),
                vehiculo.getColor(),
                vehiculo.getMarca(),
                vehiculo.getLinea(),
                vehiculo.isLicencia_vigente());
        return vehiculoDTO;
    }

    @Override
    public VehiculoDTO transporteDatos(String numero_serie) throws FindException {
        Vehiculo vehiculo = consultarVehiculoNumSerie(numero_serie);
        VehiculoDTO vehiculoDTO = new VehiculoDTO(
                vehiculo.getNumero_serie(),
                vehiculo.getModelo(),
                vehiculo.getColor(),
                vehiculo.getMarca(),
                vehiculo.getLinea(),
                vehiculo.isLicencia_vigente());
        return vehiculoDTO;
    }
}
