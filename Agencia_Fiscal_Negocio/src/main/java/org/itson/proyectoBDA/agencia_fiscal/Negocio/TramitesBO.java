
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DTO.LicenciaDTO;
import org.itson.proyectoBDA.agencia_fiscal.DTO.TramiteDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;


public class TramitesBO implements ITramitesBO{

     private ILicenciasDAO licenciaDAO;
    static final Logger logger = Logger.getLogger(TramitesBO.class.getName());

    public TramitesBO(ILicenciasDAO licenciaDAO) {
        this.licenciaDAO = licenciaDAO;
    }

    @Override
    public LicenciaDTO consultarInformacionLicencia(Licencia licencia) {
        LicenciaDTO licenciaDTO = new LicenciaDTO (
                licencia.getVigencia(), 
                licencia.getFecha_expedicion(), 
                licencia.getCosto());
        return licenciaDTO;
        }
    
}
