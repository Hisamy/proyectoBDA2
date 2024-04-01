package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        System.out.println(cliente.toString());
        TypedQuery<Licencia> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente", Licencia.class);
        query.setParameter("cliente", cliente);
        Licencia licencia = query.getSingleResult();

        entityManager.close();

        return licencia;
    }

    @Override
    public Licencia consultarDatosUltimaLicencia(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();

        TypedQuery<Licencia> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente AND l.estado = true", Licencia.class);
        query.setParameter("cliente", cliente);
        query.setMaxResults(1); // Obtener solo el primer resultado, que sería el más reciente
        Licencia licencia = query.getSingleResult();

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

    @Override
    public Licencia actualizarLicencia(Licencia licenciaActualizada) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        Licencia licenciaPersistida = entityManager.merge(licenciaActualizada);
        entityManager.getTransaction().commit();
        entityManager.close();

        return licenciaPersistida;
    }
}
