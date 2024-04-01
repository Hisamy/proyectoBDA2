package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Date;

/**
 *
 * @author Ramosz
 */
public class ReporteDTO {

    private String costo;
    private String persona;
    private Date fecha;
    private String tipo;

    /**
     *
     * @return
     */
    public String getCosto() {
        return costo;
    }

    /**
     *
     * @param costo
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public String getPersona() {
        return persona;
    }

    /**
     *
     * @param persona
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

}
