package org.itson.proyectoBDA.agencia_fiscal.dtos;


public class VehiculoDTO {
 
    private String numero_serie;
    private Integer modelo;
    private String color;
    private String marca;
    private String linea;
    private boolean licencia_vigente;

    public VehiculoDTO() {
    }

    public VehiculoDTO(
            String numero_serie, 
            Integer modelo, 
            String color, 
            String marca, 
            String linea, 
            boolean licencia_vigente) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
    }

    
    public String getNumero_serie() {
        return numero_serie;
    }

    public Integer getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getLinea() {
        return linea;
    }

    public boolean isLicencia_vigente() {
        return licencia_vigente;
    }
    
    
}
