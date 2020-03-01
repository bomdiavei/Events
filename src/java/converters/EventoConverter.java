package converters;

import entities.Evento;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Evento.class)
@Named
public class EventoConverter extends EntityConverter<Evento> {
    
    public EventoConverter() {
        super(Evento.class);
    }
}