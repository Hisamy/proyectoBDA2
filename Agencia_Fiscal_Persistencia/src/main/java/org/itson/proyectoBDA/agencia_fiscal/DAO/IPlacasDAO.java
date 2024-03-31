
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;


public interface IPlacasDAO {

    public Placa agregarPlaca(Placa nuevaPlaca);

    public Placa consultarDatosPlaca(Cliente cliente);
}
