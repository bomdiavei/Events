package services;

import entities.Voluntário;
import javax.ejb.Stateless;

@Stateless
public class VoluntárioService extends EntityService<Voluntário> {

    public VoluntárioService() {
        super(Voluntário.class);
    }    
}