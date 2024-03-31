package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.LicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;

public class RegistroLicenciasBO implements IRegistroLicenciasBO {

    private final IClientesDAO clienteDAO;
    private ILicenciasDAO licenciaDAO;

    static final Logger logger = Logger.getLogger(RegistroClientesBO.class.getName());

    public RegistroLicenciasBO() {
        IConexion conexion = new Conexion();
        this.clienteDAO = new ClientesDAO(conexion);
        this.licenciaDAO = new LicenciasDAO(conexion);
    }

    /**
     * Registra una nueva licencia en el sistema.
     *
     * @param nuevoLicencia Objeto LicenciaDTO que contiene los datos de la
     * nueva licencia a registrar.
     * @return La licencia registrada en el sistema.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la licencia.
     */
    @Override
    public Licencia registrarLicencia(LicenciaDTO nuevoLicencia) throws PersistenciaException {
        Licencia nuevaLicencia = licenciaDAO.agregarLicencia(new Licencia(
                nuevoLicencia.getVigencia(),
                nuevoLicencia.getFecha_expedicion(),
                nuevoLicencia.getCosto(),
                clienteDAO.consultarClienteRFC(nuevoLicencia.getClienteDTO().getRFC()),
                nuevoLicencia.getEstado(),
                nuevoLicencia.getFecha_emision()));
        return nuevaLicencia;
    }

    /**
     * Transporta los datos de una nueva licencia al sistema.
     *
     * @param nuevaLicencia Objeto LicenciaDTO que contiene los datos de la
     * nueva licencia a transportar.
     * @return La licencia DTO transportada.
     * @throws PersistenciaException Si ocurre un error durante el transporte de
     * los datos de la licencia.
     */
    @Override
    public LicenciaDTO transporteDatos(LicenciaDTO nuevaLicencia) throws PersistenciaException {
        try {
            registrarLicencia(nuevaLicencia);
        } catch (PersistenciaException e) {
            logger.warning("Error al transportar los datos");
        }
        return nuevaLicencia;
    }
}
