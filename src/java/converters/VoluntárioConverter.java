package converters;

import entities.Voluntário;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Voluntário.class)
@Named
public class VoluntárioConverter extends EntityConverter<Voluntário> {
    
    public VoluntárioConverter() {
        super(Voluntário.class);
    }
}