package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;

/**
 *
 * @author Ramosz
 */
public class NuevoClienteDTO {

    private String CURP;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private boolean discapacidad;
    private String RFC;
    private String telefono;
    private Calendar fecha_nacimiento;

    /**
     *
     * @param CURP
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param discapacidad
     * @param RFC
     * @param telefono
     * @param fecha_nacimiento
     */
    public NuevoClienteDTO(String CURP, String nombre, String apellido_paterno, String apellido_materno, boolean discapacidad, String RFC, String telefono, Calendar fecha_nacimiento) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacidad = discapacidad;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @return
     */
    public String getCURP() {
        return CURP;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     *
     * @return
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     *
     * @return
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     *
     * @return
     */
    public String getRFC() {
        return RFC;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @return
     */
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

}
