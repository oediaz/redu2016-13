package com.susolabs.redu.modelo.entidades;

import com.susolabs.redu.modelo.entidades.Birads;
import com.susolabs.redu.modelo.entidades.Ecografia;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T07:20:39")
@StaticMetamodel(Resultadosecografia.class)
public class Resultadosecografia_ { 

    public static volatile SingularAttribute<Resultadosecografia, BigDecimal> sensibilidadhallazgore;
    public static volatile SingularAttribute<Resultadosecografia, String> tipohallazgore;
    public static volatile SingularAttribute<Resultadosecografia, Integer> idresultadoe;
    public static volatile SingularAttribute<Resultadosecografia, Ecografia> ecografia;
    public static volatile ListAttribute<Resultadosecografia, Birads> biradsList;
    public static volatile SingularAttribute<Resultadosecografia, String> descripcionhallazgore;
    public static volatile SingularAttribute<Resultadosecografia, String> valorpredictivopositivohallazgore;

}