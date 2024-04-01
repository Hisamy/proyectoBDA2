package org.itson.proyectoBDA.agencia_fiscal.dtos;

/**
 *
 * @author Ramosz
 */
public class VehiculoDTO {

    private String numero_serie;
    private Integer modelo;
    private String color;
    private String marca;
    private String linea;
    private String tipo;
    private boolean licencia_vigente;
    private ClienteDTO clienteDTO;

    /**
     *
     */
    public VehiculoDTO() {
    }

    /**
     *
     * @param numero_serie
     * @param modelo
     * @param color
     * @param marca
     * @param linea
     * @param tipo
     * @param licencia_vigente
     * @param clienteDTO
     */
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

    /**
     *
     * @param numero_serie
     * @param modelo
     * @param color
     * @param marca
     * @param tipo
     * @param linea
     * @param licencia_vigente
     */
    public VehiculoDTO(String numero_serie, Integer modelo, String color, String marca, String tipo, String linea, boolean licencia_vigente) {
        this.numero_serie = numero_serie;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.tipo = tipo;
        this.linea = linea;
        this.licencia_vigente = licencia_vigente;
    }

    /**
     *
     * @return
     */
    public String getNumero_serie() {
        return numero_serie;
    }

    /**
     *
     * @param numero_serie
     */
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    /**
     *
     * @return
     */
    public Integer getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public boolean isLicencia_vigente() {
        return licencia_vigente;
    }

    /**
     *
     * @param licencia_vigente
     */
    public void setLicencia_vigente(boolean licencia_vigente) {
        this.licencia_vigente = licencia_vigente;
    }

    /**
     *
     * @return
     */
    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    /**
     *
     * @param clienteDTO
     */
    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

}
