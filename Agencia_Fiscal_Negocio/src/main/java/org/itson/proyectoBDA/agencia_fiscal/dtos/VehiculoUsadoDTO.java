package org.itson.proyectoBDA.agencia_fiscal.dtos;

import org.itson.proyectoBDA.agencia_fiscal.Entidades.Cliente;

public class VehiculoUsadoDTO extends VehiculoDTO {

    private String numero_placas_antiguas;

    public VehiculoUsadoDTO(
            String numero_placas_antiguas, 
            String numero_serie, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea,
            boolean licencia_vigente,
            Cliente cliente) {
        super(numero_serie, modelo, color, marca, linea, licencia_vigente, cliente);
        this.numero_placas_antiguas = numero_placas_antiguas;
    }

    public VehiculoUsadoDTO(String numero_placas_antiguas) {
        this.numero_placas_antiguas = numero_placas_antiguas;
    }

    public String getNumero_placas_antiguas() {
        return numero_placas_antiguas;
    }

}
