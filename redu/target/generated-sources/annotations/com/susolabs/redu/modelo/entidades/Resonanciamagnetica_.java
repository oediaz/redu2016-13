package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Laboratorio;
import com.susolabs.redu.modelo.entidades.ResonanciamagneticaPK;
import com.susolabs.redu.modelo.entidades.Responsableimagen;
import com.susolabs.redu.modelo.entidades.Resultadosresonanciamagnetica;
import com.susolabs.redu.modelo.entidades.Screening;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Resonanciamagnetica.class)
public class Resonanciamagnetica_ { 

    public static volatile SingularAttribute<Resonanciamagnetica, Date> fecharm;
    public static volatile SingularAttribute<Resonanciamagnetica, Screening> screening;
    public static volatile SingularAttribute<Resonanciamagnetica, String> indicacionespecificidadrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> descripcionrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> patronreforzamientorm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> observacionrm;
    public static volatile SingularAttribute<Resonanciamagnetica, Laboratorio> laboratorio;
    public static volatile SingularAttribute<Resonanciamagnetica, ResonanciamagneticaPK> resonanciamagneticaPK;
    public static volatile SingularAttribute<Resonanciamagnetica, Responsableimagen> responsableimagen;
    public static volatile SingularAttribute<Resonanciamagnetica, String> razonrm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> observacionesprotocolorm;
    public static volatile SingularAttribute<Resonanciamagnetica, String> protocolorm;
    public static volatile ListAttribute<Resonanciamagnetica, Resultadosresonanciamagnetica> resultadosresonanciamagneticaList;

}