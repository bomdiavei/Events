package beans;

import entities.Voluntário;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import services.VoluntárioService;

@Named(value = "voluntárioBean")
@ViewScoped
public class VoluntárioBean implements Serializable {
    @EJB
    private VoluntárioService voluntárioService;

    @Inject
    private RequestParameters parameters;

    private Voluntário value;
    
    private boolean consultar;
    
    private List<Voluntário> voluntáriosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Voluntário();
        else value = voluntárioService.find(Long.valueOf(id));
    }
    
    public void consultar (Voluntário value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
        consultar = false;
    } 
    
    public void reset () {
        value = new Voluntário();
    }
    
    public Voluntário getValue() {
        return value;
    }

    public void setValue(Voluntário value) {
        this.value = value;
    }

    public List<Voluntário> getAll() {
        return voluntárioService.getAll();
    }

    public String save() {
        voluntárioService.create(value);
        reset();
        return null;
    }

    public String update() {
        voluntárioService.edit(value);
        return null;
    }

    public String delete() {
        voluntárioService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Voluntário> getVoluntáriosFiltrados() {
        return voluntáriosFiltrados;
    }

    public void setVoluntáriosFiltrados(List<Voluntário> voluntáriosFiltrados) {
        this.voluntáriosFiltrados = voluntáriosFiltrados;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep(); 
    }
    
    public SelectItem[] getEstadosCivis(){
        SelectItem[] itens = new SelectItem[Voluntário.EstadoCivil.values().length];
        int n = 0;
        for(Voluntário.EstadoCivil estadoCivil : Voluntário.EstadoCivil.values()){
            itens[n++] = new SelectItem(estadoCivil, estadoCivil.getLabel());
        }
        return itens;
    }
}