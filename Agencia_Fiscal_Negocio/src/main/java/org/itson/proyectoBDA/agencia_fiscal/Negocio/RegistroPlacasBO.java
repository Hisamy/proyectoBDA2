package org.itson.proyectoBDA.agencia_fiscal.Negocio;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.Conexion;
import org.itson.proyectoBDA.agencia_fiscal.Conexion.IConexion;
import org.itson.proyectoBDA.agencia_fiscal.DAO.ClientesDAO;
import org.itson.proyectoBDA.agencia_fiscal.Entidades.Placa;
import org.itson.proyectoBDA.agencia_fiscal.Excepciones.PersistenciaException;
import org.itson.proyectoBDA.agencia_fiscal.dtos.ClienteDTO;
import org.itson.proyectoBDA.agencia_fiscal.dtos.PlacaDTO;

public class RegistroPlacasBO implements IRegistroPlacasBO {

    IConexion conexion = new Conexion();
    ClientesDAO clienteDAO = new ClientesDAO(conexion);
    @Override
    public Placa registrarPlaca(PlacaDTO nuevaPlaca, ClienteDTO clienteDTO) throws PersistenciaException {
        Placa placaNueva = new Placa(
                nuevaPlaca.getNumero_alfanumerico(), 
                nuevaPlaca.getFecha_recepcion(), 
                true,
                nuevaPlaca.getVehiculo(), 
                nuevaPlaca.getFecha_expedicion(), 
                nuevaPlaca.getCosto(), 
                clienteDAO.consultarCliente(clienteDTO.getRFC()));
        return placaNueva;
    }

    @Override
    public PlacaDTO transporteDatos(PlacaDTO nuevaPlaca, ClienteDTO clienteDTO) throws PersistenciaException {

        

        PlacaDTO placaDTO = new PlacaDTO(
                generarNumeroAlfanumerico(),
                getFechaRecepcion(),
                true,
                nuevaPlaca.getVehiculo(),
                nuevaPlaca.getFecha_expedicion(),
                nuevaPlaca.getCosto());
        registrarPlaca(placaDTO, clienteDTO);
        
        return placaDTO;

    }

    private String generarNumeroAlfanumerico() {
        char[] caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        String placa;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int indice = random.nextInt(caracteres.length);
            builder.append(caracteres[indice]);
        }
        placa = builder.toString();

        return placa;
    }

    @Override
    public Calendar getFechaRecepcion() {
        TimeZone zonaHoraria = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(zonaHoraria);
        return calendar;
    }

}
