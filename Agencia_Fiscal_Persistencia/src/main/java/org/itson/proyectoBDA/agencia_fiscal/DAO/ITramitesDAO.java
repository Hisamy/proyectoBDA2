
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import java.util.List;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.FindException;


public interface ITramitesDAO {
    public List<Tramite> consultarTramites() throws FindException;
}
