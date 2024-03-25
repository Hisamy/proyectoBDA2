package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.LicenciaDTO;


public interface IRegistroLicenciasBO {

    Licencia registrarLicencia(LicenciaDTO nuevoLicencia,String RFC) throws PersistenciaException;

    LicenciaDTO transporteDatos(LicenciaDTO nuevaLicencia, String RFC) throws PersistenciaException;
}
