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

    @Override
    public Licencia registrarLicencia(LicenciaDTO nuevoLicencia) throws PersistenciaException {
        Licencia nuevaLicencia = licenciaDAO.agregarLicencia(new Licencia(
                nuevoLicencia.getVigencia(),
                nuevoLicencia.getFecha_expedicion(),
                nuevoLicencia.getCosto(),
                clienteDAO.consultarClienteRFC(nuevoLicencia.getClienteDTO().getRFC())));
        return nuevaLicencia;
    }

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
