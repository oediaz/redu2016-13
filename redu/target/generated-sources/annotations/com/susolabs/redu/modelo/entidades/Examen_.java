package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Examinacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile SingularAttribute<Examen, String> nombreexamen;
    public static volatile ListAttribute<Examen, Examinacion> examinacionList;
    public static volatile SingularAttribute<Examen, String> descripcionexamen;
    public static volatile SingularAttribute<Examen, Integer> idexamen;

}