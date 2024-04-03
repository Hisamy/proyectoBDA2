package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IRegistroLicenciasBO {

    /**
     * Registra una nueva licencia.
     *
     * @param nuevoLicencia El objeto LicenciaDTO que representa la nueva
     * licencia a registrar.
     * @return La licencia registrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    Licencia registrarLicencia(LicenciaDTO nuevoLicencia) throws PersistenciaException;

    /**
     * Transporta los datos de una licencia.
     *
     * @param nuevaLicencia El objeto LicenciaDTO que contiene los datos de la
     * licencia a transportar.
     * @return Los datos de la licencia transportados.
     * @throws PersistenciaException Si ocurre un error durante el transporte de
     * datos.
     */
    LicenciaDTO transporteDatos(LicenciaDTO nuevaLicencia) throws PersistenciaException;

    /**
     * Convierte un objeto ClienteDTO a un objeto Cliente.
     *
     * @param clienteDTO El objeto ClienteDTO a convertir.
     * @return El objeto Cliente convertido.
     * @throws PersistenciaException Si ocurre un error durante la conversión.
     */
    Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException;

}
