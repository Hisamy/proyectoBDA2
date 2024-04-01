package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;

/**
 *
 * @author Ramosz
 */
public interface ILicenciasDAO {

    /**
     *
     * @param nuevaLicencia
     * @return
     */
    public Licencia agregarLicencia(Licencia nuevaLicencia);

    /**
     *
     * @param cliente
     * @return
     */
    public Licencia consultarDatosLicencia(Cliente cliente);

    /**
     *
     * @param licenciaActualizada
     * @return
     */
    public Licencia actualizarLicencia(Licencia licenciaActualizada);

    /**
     *
     * @param cliente
     * @return
     */
    public Licencia consultarDatosUltimaLicencia(Cliente cliente);

}
