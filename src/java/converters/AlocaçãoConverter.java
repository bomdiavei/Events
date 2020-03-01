package converters;

import entities.Alocação;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Alocação.class)
@Named
public class AlocaçãoConverter extends EntityConverter<Alocação> {
    
    public AlocaçãoConverter() {
        super(Alocação.class);
    }
}