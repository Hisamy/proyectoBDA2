package org.itson.proyectoBDA.agencia_fiscal.dtos;


public class VehiculoUsadoDTO extends VehiculoDTO{
    private String numero_placas_antiguas;

    public VehiculoUsadoDTO(String numero_placas_antiguas, String numero_serie, Integer modelo, String color, String marca, String linea, boolean licencia_vigente) {
        super(numero_serie, modelo, color, marca, linea, licencia_vigente);
        this.numero_placas_antiguas = numero_placas_antiguas;
    }

    public VehiculoUsadoDTO(String numero_placas_antiguas) {
        this.numero_placas_antiguas = numero_placas_antiguas;
    }

    public String getNumero_placas_antiguas() {
        return numero_placas_antiguas;
    }
    
    
}
