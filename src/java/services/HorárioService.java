package services;

import entities.Horário;
import javax.ejb.Stateless;

@Stateless
public class HorárioService extends EntityService<Horário> {

    public HorárioService() {
        super(Horário.class);
    }    
}