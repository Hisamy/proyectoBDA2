package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Licencia;

public class LicenciasDAO implements ILicenciasDAO {

    final private IConexion conexion;

    public LicenciasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Licencia consultarDatosLicencia(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();
        Licencia licencia = entityManager.find(Licencia.class, cliente.getId_cliente());
        entityManager.close();
        return licencia;
    }

    @Override
    public Licencia agregarLicencia(Licencia nuevaLicencia) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevaLicencia);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevaLicencia;
    }
}
