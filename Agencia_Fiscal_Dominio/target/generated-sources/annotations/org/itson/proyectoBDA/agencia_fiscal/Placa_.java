package org.itson.proyectoBDA.agencia_fiscal;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-19T21:19:15", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, String> numero_serie;
    public static volatile SingularAttribute<Placa, Boolean> activacion;
    public static volatile SingularAttribute<Placa, String> numero_alfanumerico;
    public static volatile SingularAttribute<Placa, Calendar> fecha_recepcion;

}