
package org.itson.proyectoBDA.agencia_fiscal.Conexion;

import javax.persistence.EntityManager;


public interface IConexion {
    public EntityManager crearConexion();
}
