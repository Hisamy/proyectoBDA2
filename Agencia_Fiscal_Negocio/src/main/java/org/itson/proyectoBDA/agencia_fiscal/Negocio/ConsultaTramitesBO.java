package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ITramitesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.LicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.TramitesDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

public class ConsultaTramitesBO implements IConsultaTramitesBO {

    private final ILicenciasDAO licenciaDAO;
    private final IClientesDAO clienteDAO;
    private final ITramitesDAO tramiteDAO;

    public ConsultaTramitesBO() {
        Conexion conexion = new Conexion();
        this.licenciaDAO = new LicenciasDAO(conexion);
        this.tramiteDAO = new TramitesDAO(conexion);
        this.clienteDAO = new ClientesDAO(conexion);
    }

    /**
     * Consulta la licencia asociada al cliente especificado.
     *
     * @param cliente El cliente para el cual se desea consultar la licencia.
     * @return La licencia asociada al cliente.
     * @throws FindException Si hay algún error al intentar encontrar la licencia en la base de datos.
     */
    @Override
    public Licencia consultarLicencia(Cliente cliente) throws FindException {
        Licencia licencia = null;
        try {
            licencia = licenciaDAO.consultarDatosLicencia(clienteDAO.consultarClienteRFC(cliente.getRFC()));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Licencia getLicencia = new Licencia(
                licencia.getVigencia(),
                licencia.getFecha_expedicion(),
                licencia.getTipo_tramite(),
                licencia.getCosto(),
                cliente);
        return getLicencia;
    }

    /**
     * Transporta los datos de un objeto ClienteDTO a un objeto Cliente y consulta su licencia asociada.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del cliente.
     * @return
     * @throws FindException Si hay algún error al intentar encontrar la licencia asociada al cliente.
     */
    @Override
    public Cliente transporteDatosConsultarCliente(ClienteDTO clienteDTO) throws FindException {
        Cliente cliente = new Cliente(
                clienteDTO.getCURP(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido_paterno(),
                clienteDTO.getApellido_materno(),
                clienteDTO.isDiscapacidad(),
                clienteDTO.getRFC(),
                clienteDTO.getTelefono(),
                clienteDTO.getFecha_nacimiento());
        consultarLicencia(cliente);
        return cliente;
    }

    /**
     * Transporta los datos de un objeto ClienteDTO y consulta su licencia asociada. Este método solo ejecuta el método transporteDatosConsultarCliente, atrapando cualquier excepción y registrándola.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del cliente.
     * @return true si la operación de transporte de datos y consulta de licencia se realiza correctamente, de lo contrario, retorna false.
     */
    @Override
    public Boolean transporteDatos(ClienteDTO clienteDTO) {
        try {
            if (transporteDatosConsultarCliente(clienteDTO) != null) {
                return true;
            }
        } catch (FindException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Consulta el historial de trámites y lo convierte a una lista de objetos TramiteDTO.
     *
     * @return Una lista de objetos TramiteDTO que representa el historial de trámites.
     */
    @Override
    public List<TramiteDTO> historialTramite() throws FindException {
        try {
            List<Tramite> tramites = tramiteDAO.consultarTramites();
            List<TramiteDTO> tramitesDTO = new ArrayList<>();
            for (Tramite tramite : tramites) {
                TramiteDTO tramiteDTO = new TramiteDTO(
                        tramite.getFecha_expedicion(),
                        tramite.getCosto(),
                        convertirClienteADTO(tramite.getCliente()));
                //persona

                tramitesDTO.add(tramiteDTO);
            }
            return tramitesDTO;
        } catch (FindException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new FindException(ex.getMessage());
        }

    }

    /**
     * Convierte un objeto Cliente a un objeto ClienteDTO.
     *
     * @param cliente Objeto Cliente que se va a convertir a ClienteDTO.
     * @return Objeto ClienteDTO que representa al cliente convertido.
     */
    public ClienteDTO convertirClienteADTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getCURP(),
                cliente.getNombre(),
                cliente.getApellido_paterno(),
                cliente.getApellido_materno(),
                cliente.isDiscapacidad(),
                cliente.getRFC(),
                cliente.getTelefono(),
                cliente.getFecha_nacimiento());
    }
}
