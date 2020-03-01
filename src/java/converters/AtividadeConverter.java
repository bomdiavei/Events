package converters;

import entities.Atividade;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Atividade.class)
@Named
public class AtividadeConverter extends EntityConverter<Atividade> {
    
    public AtividadeConverter() {
        super(Atividade.class);
    }
}