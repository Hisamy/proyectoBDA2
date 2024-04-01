package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;

/**
 *
 * @author Ramosz
 */
public interface IRegistroLicenciasBO {

    /**
     *
     * @param nuevoLicencia
     * @return
     * @throws PersistenciaException
     */
    Licencia registrarLicencia(LicenciaDTO nuevoLicencia) throws PersistenciaException;

    /**
     *
     * @param nuevaLicencia
     * @return
     * @throws PersistenciaException
     */
    LicenciaDTO transporteDatos(LicenciaDTO nuevaLicencia) throws PersistenciaException;

    /**
     *
     * @param clienteDTO
     * @return
     * @throws PersistenciaException
     */
    Cliente convertirClienteADTO(ClienteDTO clienteDTO) throws PersistenciaException;
}
