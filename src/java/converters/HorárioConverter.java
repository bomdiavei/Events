package converters;

import entities.Horário;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Horário.class)
@Named
public class HorárioConverter extends EntityConverter<Horário> {
    
    public HorárioConverter() {
        super(Horário.class);
    }
}