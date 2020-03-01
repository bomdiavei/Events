package entities;

import entities.Evento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2019-06-04T06:16:30")
@StaticMetamodel(Atividade.class)
public class Atividade_ { 

    public static volatile SingularAttribute<Atividade, String> função;
    public static volatile SingularAttribute<Atividade, Integer> quantidadeNecessária;
    public static volatile ListAttribute<Atividade, Evento> eventos;
    public static volatile SingularAttribute<Atividade, Long> id;

}