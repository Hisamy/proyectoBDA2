package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.logging.Logger;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ILicenciasDAO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;

public class ConsultaTramitesBO implements IConsultaTramitesBO {

    private ILicenciasDAO licenciaDAO;
    static final Logger logger = Logger.getLogger(ConsultaTramitesBO.class.getName());

    public ConsultaTramitesBO(ILicenciasDAO licenciaDAO) {
        this.licenciaDAO = licenciaDAO;
    }

    @Override
    public LicenciaDTO consultarInformacionLicencia(Licencia licencia) {
        LicenciaDTO licenciaDTO = new LicenciaDTO(
                licencia.getVigencia(),
                licencia.getFecha_expedicion(),
                licencia.getCosto());
        return licenciaDTO;
    }

}
