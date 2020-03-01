package converters;

import entities.Organizador;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Organizador.class)
@Named
public class OrganizadorConverter extends EntityConverter<Organizador> {
    
    public OrganizadorConverter() {
        super(Organizador.class);
    }
}
