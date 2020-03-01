package entities;

import entities.Atividade;
import entities.Evento.Tipo;
import entities.Horário;
import entities.Organizador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2019-06-04T06:16:30")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile ListAttribute<Evento, Atividade> atividades;
    public static volatile SingularAttribute<Evento, Tipo> tipo;
    public static volatile SingularAttribute<Evento, Horário> horário;
    public static volatile SingularAttribute<Evento, Integer> ano;
    public static volatile SingularAttribute<Evento, String> título;
    public static volatile SingularAttribute<Evento, Long> id;
    public static volatile SingularAttribute<Evento, Organizador> organizador;

}