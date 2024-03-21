
package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import org.itson.proyectoBDA.agencia_fiscal.DAO.IClientesDAO;


public class Consulta_ClientesBO implements IConsulta_ClientesBO{
    private IClientesDAO clientesDAO;

    public Consulta_ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
    
    
    
}
