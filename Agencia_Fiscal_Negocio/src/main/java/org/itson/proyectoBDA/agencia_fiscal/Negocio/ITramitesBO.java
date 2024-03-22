
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.DTO.LicenciaDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;


public interface ITramitesBO {
    
    public LicenciaDTO consultarInformacionLicencia(Licencia licencia);
    
}
