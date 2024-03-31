package org.itson.proyectoBDA.agencia_fiscal.dtos;

public class VehiculoDTO {

    private String numero_serie;
    private Integer modelo;
    private String color;
    private String marca;
    private String linea;
    private String tipo;
    private boolean licencia_vigente;
    private ClienteDTO clienteDTO;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String numero_serie, Integer modelo, String color, String marca, String linea, String tipo, boolean licencia_vigente, ClienteDTO clienteDTO) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.tipo = tipo;
        this.licencia_vigente = licencia_vigente;
        this.clienteDTO = clienteDTO;
    }

    public VehiculoDTO(String numero_serie, Integer modelo, String color, String marca, String tipo, boolean licencia_vigente) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.tipo = tipo;
        this.licencia_vigente = licencia_vigente;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isLicencia_vigente() {
        return licencia_vigente;
    }

    public void setLicencia_vigente(boolean licencia_vigente) {
        this.licencia_vigente = licencia_vigente;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

}
