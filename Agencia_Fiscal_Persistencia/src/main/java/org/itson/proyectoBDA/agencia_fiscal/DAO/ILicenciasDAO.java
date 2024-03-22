
package org.itson.proyectoBDA.agencia_fiscal.DAO;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;


public interface ILicenciasDAO {
    public Licencia agregarLicencia(Licencia nuevaLicencia);
    public Licencia consultarDatosLicencia();
    
}
