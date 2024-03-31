package org.itson.proyectoBDA.agencia_fiscal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import static org.itson.proyectoBDA.agencia_fiscal.Entidades.Tramite_.id;

public class PlacasDAO implements IPlacasDAO {

    final private IConexion conexion;

    public PlacasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta los datos de la placa asociada a un cliente.
     *
     * @param cliente El cliente cuya placa se va a consultar.
     * @return La placa asociada al cliente.
     */
    @Override
    public Placa consultarDatosPlaca(Cliente cliente) {
        EntityManager entityManager = conexion.crearConexion();
        TypedQuery<Placa> query = entityManager.createQuery(
                "SELECT l FROM Licencia l WHERE l.cliente = :cliente", Placa.class);
        query.setParameter("cliente", cliente);
        Placa placa = query.getSingleResult();

        entityManager.close();
        return placa;
    }

    /**
     * Agrega una nueva placa a la base de datos.
     *
     * @param nuevaPlaca La nueva placa que se va a agregar.
     * @return La placa agregada.
     */
    @Override
    public Placa agregarPlaca(Placa nuevaPlaca) {
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.merge(nuevaPlaca);
        entityManager.getTransaction().commit();
        entityManager.close();

        return nuevaPlaca;
    }

}
