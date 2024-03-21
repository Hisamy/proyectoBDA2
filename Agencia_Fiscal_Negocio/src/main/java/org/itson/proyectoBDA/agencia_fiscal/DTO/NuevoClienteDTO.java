
package org.itson.proyectoBDA.agencia_fiscal.dto;

import java.util.Calendar;


public class NuevoClienteDTO {

    private String CURP;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private boolean discapacidad;
    private String RFC;
    private String telefono;
    private Calendar fecha_nacimiento;

    public String getCURP() {
        return CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public String getRFC() {
        return RFC;
    }

    public String getTelefono() {
        return telefono;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

  
    
    
}
