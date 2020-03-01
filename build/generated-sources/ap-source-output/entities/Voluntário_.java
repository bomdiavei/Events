package entities;

import entities.Endereço;
import entities.Voluntário.EstadoCivil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2019-06-04T06:16:30")
@StaticMetamodel(Voluntário.class)
public class Voluntário_ { 

    public static volatile SingularAttribute<Voluntário, String> rg;
    public static volatile SingularAttribute<Voluntário, String> cpf;
    public static volatile SingularAttribute<Voluntário, Endereço> endereço;
    public static volatile SingularAttribute<Voluntário, String> nome;
    public static volatile SingularAttribute<Voluntário, EstadoCivil> estadoCivil;
    public static volatile SingularAttribute<Voluntário, Long> id;
    public static volatile SingularAttribute<Voluntário, String> sexo;
    public static volatile SingularAttribute<Voluntário, Date> dataNascimento;

}