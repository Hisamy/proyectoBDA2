package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IPlacasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ITramitesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.LicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.PlacasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.TramitesDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.TramiteDTO;

/**
 *
 * @author Ramosz
 */
public class ConsultaTramitesBO implements IConsultaTramitesBO {

    private final ILicenciasDAO licenciaDAO;
    private final IPlacasDAO placaDAO;
    private final IClientesDAO clienteDAO;
    private final ITramitesDAO tramiteDAO;

    /**
     *
     */
    public ConsultaTramitesBO() {
        Conexion conexion = new Conexion();
        this.licenciaDAO = new LicenciasDAO(conexion);
        this.placaDAO = new PlacasDAO(conexion);
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
            licencia = licenciaDAO.consultarDatosUltimaLicencia(clienteDAO.consultarClienteRFC(cliente.getRFC()));
            if (licencia == null) {
                JOptionPane.showMessageDialog(null, "El cliente no tiene una licencia activa.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Licencia getLicencia = new Licencia(
                        licencia.getVigencia(),
                        licencia.getFecha_expedicion(),
                        licencia.getTipo_tramite(),
                        licencia.getCosto(),
                        cliente,
                        licencia.getEstado(),
                        licencia.getFecha_emision());
                return getLicencia;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoResultException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna licencia para el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     *
     * @param cliente
     * @return
     * @throws FindException
     */
    @Override
    public Placa consultarPlaca(Cliente cliente) throws FindException {
        Placa placa = null;
        placa = placaDAO.consultarDatosPlaca(cliente);
        Placa getPlaca = new Placa(
                placa.getNumero_alfanumerico(),
                placa.getFecha_recepcion(),
                placa.getVehiculo(),
                placa.getFecha_expedicion(),
                placa.getTipo_tramite(),
                placa.getCosto(),
                placa.getCliente(),
                placa.getEstado(),
                placa.getFecha_emision());
        return placa;
    }

    /**
     * Transporta los datos de un objeto ClienteDTO a un objeto Cliente y consulta su licencia asociada.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del cliente.
     * @return El cliente con su licencia asociada si existe y está activa, de lo contrario, retorna null.
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

        // Consultar la licencia asociada al cliente
        Licencia licencia = consultarLicencia(cliente);

        // Verificar si el cliente tiene una licencia activa
        if (licencia != null && licencia.getEstado().equals("Activa")) {
            return cliente; // Devuelve el cliente con su licencia activa
        } else {
            // Si el cliente no tiene una licencia activa, muestra un JOptionPane
            JOptionPane.showMessageDialog(null, "El cliente no tiene una licencia activa.", "Licencia No Válida", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /**
     * Transporta los datos de un objeto ClienteDTO y consulta su licencia asociada. Este método solo ejecuta el método validarLicencia, atrapando cualquier excepción y registrándola.
     *
     * @param clienteDTO El objeto ClienteDTO que contiene los datos del cliente.
     * @return true si la operación de transporte de datos y consulta de licencia se realiza correctamente, de lo contrario, retorna false.
     */
    @Override
    public Boolean transporteDatos(ClienteDTO clienteDTO) {
        try {
            return validarLicencia(clienteDTO); // Simplemente llama al método validarLicencia y devuelve su resultado
        } catch (FindException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Devuelve false si hay una excepción
        }
    }

    /**
     * Consulta el historial de trámites y lo convierte a una lista de objetos TramiteDTO.
     *
     * @return Una lista de objetos TramiteDTO que representa el historial de trámites.
     * @throws org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException
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
                        convertirClienteADTO(tramite.getCliente()),
                        tramite.getEstado(),
                        tramite.getTipo_tramite(),
                        tramite.getFecha_emision());
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

    @Override
    public boolean validarLicencia(ClienteDTO clienteDTO) throws FindException {
        try {
            Licencia licencia = consultarLicencia(clienteDAO.consultarClienteRFC(clienteDTO.getRFC()));
            if (licencia == null) {
                return false;
            } else {
                return true;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(ConsultaTramitesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
