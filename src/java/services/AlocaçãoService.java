package services;

import entities.Alocação;
import javax.ejb.Stateless;

@Stateless
public class AlocaçãoService extends EntityService<Alocação> {

    public AlocaçãoService() {
        super(Alocação.class);
    }   
}