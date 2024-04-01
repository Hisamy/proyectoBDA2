package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IPlacasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.IVehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.PlacasDAO;
import org.itson.proyectoBDA.agencia_fiscal.DAO.VehiculosDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Vehiculo;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.VehiculoDTO;

public class RegistroPlacasBO implements IRegistroPlacasBO {

    IConexion conexion = new Conexion();
    ClientesDAO clienteDAO = new ClientesDAO(conexion);
    IVehiculosDAO vehiculoDAO;
    private String tipo = "Placa";
    private IPlacasDAO placaDAO;

    public RegistroPlacasBO() {
        IConexion conexion = new Conexion();
        this.placaDAO = new PlacasDAO(conexion);
        this.vehiculoDAO = new VehiculosDAO(conexion);
    }

    /**
     * Registra una nueva placa en el sistema utilizando los datos proporcionados en un objeto PlacaDTO.
     *
     * @param nuevaPlaca El objeto PlacaDTO que contiene los datos de la nueva placa a registrar.
     * @param vehiculo
     * @return El objeto Placa recién registrado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    @Override
    public Placa registrarPlaca(PlacaDTO nuevaPlaca, Vehiculo vehiculo) throws PersistenciaException {
        Cliente cliente = clienteDAO.consultarClienteRFC(nuevaPlaca.getClienteDTO().getRFC());

        Placa placa = new Placa(
                generarNumeroAlfanumerico(),
                getFechaRecepcion(),
                vehiculo,
                nuevaPlaca.getFecha_expedicion(),
                nuevaPlaca.getCosto(),
                cliente,
                true,
                nuevaPlaca.getFecha_emision());

        Vehiculo vehiculoID = vehiculoDAO.consultarVehiculo(placa.getVehiculo().getNumero_serie());
        placa.getVehiculo().setId(vehiculoID.getId());
        placa.getVehiculo().setCliente(cliente);
        Placa placaNueva = placaDAO.agregarPlaca(placa);
        return placaNueva;
    }

    @Override
    public VehiculoDTO conversorVehiculoDTO(PlacaDTO nuevaPlaca) throws PersistenciaException {
        VehiculoDTO vehiculoDTO = nuevaPlaca.getVehiculo();
        Vehiculo nuevoVehiculo = new Vehiculo(
                vehiculoDTO.getNumero_serie(),
                vehiculoDTO.getTipo(),
                vehiculoDTO.getModelo(),
                vehiculoDTO.getColor(),
                vehiculoDTO.getMarca(),
                vehiculoDTO.getLinea(),
                true);
        registrarPlaca(nuevaPlaca, nuevoVehiculo);
        return vehiculoDTO;
    }

    /**
     * Transporta los datos de una nueva placa y registra la placa en el sistema.
     *
     * @param nuevaPlaca El objeto PlacaDTO que contiene los datos de la nueva placa a registrar.
     * @return El objeto PlacaDTO transportado, que contiene los mismos datos que la placa registrada.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    @Override
    public PlacaDTO transporteDatos(PlacaDTO nuevaPlaca) throws PersistenciaException {
        Calendar fechaActual = Calendar.getInstance();
        PlacaDTO placaDTO = new PlacaDTO(
                generarNumeroAlfanumerico(),
                getFechaRecepcion(),
                nuevaPlaca.getVehiculo(),
                nuevaPlaca.getFecha_expedicion(),
                nuevaPlaca.getCosto(),
                nuevaPlaca.getClienteDTO(),
                true,
                tipo,
                fechaActual);
        conversorVehiculoDTO(placaDTO);

        return placaDTO;

    }

    /**
     * Genera y devuelve un número alfanumérico único que puede ser utilizado como número de placa.
     *
     * @return Un número alfanumérico único que representa una placa de vehículo.
     */
    private String generarNumeroAlfanumerico() {
        StringBuilder placa = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            char letra = (char) ('A' + random.nextInt(26)); // Generar una letra aleatoria entre A y Z
            placa.append(letra);
        }

        placa.append("-");

        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10); // Generar un dígito aleatorio entre 0 y 9
            placa.append(digito);
        }

        return placa.toString();
    }

    /**
     * Obtiene la fecha y hora actuales del sistema en un objeto Calendar.
     *
     * @return Un objeto Calendar que representa la fecha y hora actuales del sistema.
     */
    @Override
    public Calendar getFechaRecepcion() {
        TimeZone zonaHoraria = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(zonaHoraria);
        return calendar;
    }

}
