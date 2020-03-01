package services;

import entities.Evento;
import javax.ejb.Stateless;

@Stateless
public class EventoService extends EntityService<Evento> {

    public EventoService() {
        super(Evento.class);
    }   
}