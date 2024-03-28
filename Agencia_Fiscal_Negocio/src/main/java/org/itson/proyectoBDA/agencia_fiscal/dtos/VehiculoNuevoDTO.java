package org.itson.proyectoBDA.agencia_fiscal.dtos;

public class VehiculoNuevoDTO extends VehiculoDTO {

    public VehiculoNuevoDTO(String numero_serie, Integer modelo, String color, String marca, String linea, boolean licencia_vigente, ClienteDTO clienteDTO) {
        super(numero_serie, modelo, color, marca, linea, licencia_vigente, clienteDTO);
    }

}
