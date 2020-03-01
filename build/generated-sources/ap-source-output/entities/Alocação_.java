package entities;

import entities.Evento;
import entities.Voluntário;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2019-06-04T06:16:30")
@StaticMetamodel(Alocação.class)
public class Alocação_ { 

    public static volatile SingularAttribute<Alocação, Voluntário> voluntário;
    public static volatile SingularAttribute<Alocação, Evento> evento;
    public static volatile SingularAttribute<Alocação, Long> id;
    public static volatile SingularAttribute<Alocação, Date> dataHora;

}