package org.itson.proyectoBDA.agencia_fiscal.dtos;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Ramosz
 */
public class ClienteDTO {

    private String CURP;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private boolean discapacidad;
    private String RFC;
    private String telefono;
    private Calendar fecha_nacimiento;
    private List<TramiteDTO> tramitesDTO;
    private List<VehiculoDTO> vehiculosDTO;

    /**
     *
     * @param RFC
     */
    public ClienteDTO(String RFC) {
        this.RFC = RFC;
    }

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
    public ClienteDTO(String CURP, String nombre, String apellido_paterno, String apellido_materno, boolean discapacidad, String RFC, String telefono, Calendar fecha_nacimiento) {
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
     * @param CURP
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param discapacidad
     * @param RFC
     * @param telefono
     * @param fecha_nacimiento
     * @param tramitesDTO
     * @param vehiculosDTO
     */
    public ClienteDTO(String CURP, String nombre, String apellido_paterno, String apellido_materno, boolean discapacidad, String RFC, String telefono, Calendar fecha_nacimiento, List<TramiteDTO> tramitesDTO, List<VehiculoDTO> vehiculosDTO) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.discapacidad = discapacidad;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tramitesDTO = tramitesDTO;
        this.vehiculosDTO = vehiculosDTO;
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

    /**
     *
     * @return
     */
    public List<TramiteDTO> getTramitesDTO() {
        return tramitesDTO;
    }

    /**
     *
     * @return
     */
    public List<VehiculoDTO> getVehiculosDTO() {
        return vehiculosDTO;
    }
    

}
