package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;

/**
 *
 * @author Ramosz
 */
public interface IPlacasDAO {

    /**
     *
     * @param nuevaPlaca
     * @return
     */
    public Placa agregarPlaca(Placa nuevaPlaca);

    /**
     *
     * @param cliente
     * @return
     */
    public Placa consultarDatosPlaca(Cliente cliente);

    /**
     *
     * @param cliente
     * @return
     */
    public Placa consultarDatosUltimaLicencia(Cliente cliente);

    /**
     *
     * @param placaActualizada
     * @return
     */
    public Placa actualizarPlaca(Placa placaActualizada);
}
