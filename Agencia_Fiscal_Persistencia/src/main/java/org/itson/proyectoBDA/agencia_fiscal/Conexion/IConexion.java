package org.itson.proyectoBDA.agencia_fiscal.Conexion;

import javax.persistence.EntityManager;

/**
 *
 * @author Ramosz
 */
public interface IConexion {

    /**
     *
     * @return
     */
    public EntityManager crearConexion();
}
