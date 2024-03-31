package org.itson.proyectoBDA.agencia_fiscal.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "licencias")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "vigencia", nullable = false, length = 5)
    private Integer vigencia;

    public Licencia() {
    }

    public Licencia(Long id, Calendar fecha_expedicion, String tipo_tramite, Float costo, Cliente cliente) {
        super(id, fecha_expedicion, tipo_tramite, costo, cliente);
    }

    public Licencia(Integer vigencia, Calendar fecha_expedicion, Float costo, Cliente cliente) {
        super(fecha_expedicion, costo, cliente);
        this.vigencia = vigencia;
    }

    public Licencia(Integer vigencia, Calendar fecha_expedicion, String tipo_tramite, Float costo, Cliente cliente) {
        super(fecha_expedicion, tipo_tramite, costo, cliente);
        this.vigencia = vigencia;
    }

    public Licencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

}
