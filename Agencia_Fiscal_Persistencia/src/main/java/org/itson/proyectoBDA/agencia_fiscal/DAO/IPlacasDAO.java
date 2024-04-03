package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;

/**
 *
 * @author Eduardo Talavera, Hisamy Cinco
 */
public interface IPlacasDAO {

    /**
     * Agrega una nueva placa a la base de datos.
     *
     * @param nuevaPlaca La placa a agregar.
     * @return La placa agregada.
     */
    public Placa agregarPlaca(Placa nuevaPlaca);

    /**
     * Consulta los datos de la placa asociada a un cliente específico.
     *
     * @param cliente El cliente para el cual se desea consultar la placa.
     * @return La placa asociada al cliente especificado.
     */
    public Placa consultarDatosPlaca(Cliente cliente);

    /**
     * Consulta los datos de la última placa activa asociada a un cliente en
     * particular.
     *
     * @param cliente El cliente para el cual se desea consultar la última placa
     * activa.
     * @return La última placa activa asociada al cliente especificado.
     */
    public Placa consultarDatosUltimaLicencia(Cliente cliente);

    /**
     * Actualiza los datos de una placa en la base de datos.
     *
     * @param placaActualizada La placa con los datos actualizados.
     * @return La placa actualizada.
     */
    public Placa actualizarPlaca(Placa placaActualizada);

    /**
     * Valida si una placa con el número alfanumérico especificado existe en la
     * base de datos.
     *
     * @param numero_alfanumerico El número alfanumérico de la placa a validar.
     * @return true si la placa existe en la base de datos, false en caso
     * contrario.
     */
    public boolean validarPlaca(String numero_alfanumerico);

}
