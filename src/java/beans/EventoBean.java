package beans;

import entities.Evento;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.EventoService;

@Named(value = "eventoBean")
@ViewScoped
public class EventoBean implements Serializable {
    @EJB
    private EventoService eventoService;
    
    @Inject
    private RequestParameters parameters;

    private Evento value;
    
    private boolean consultar;
    
    private List<Evento> eventosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Evento();
        else value = eventoService.find(Long.valueOf(id));
    }
    
    public void consultar (Evento value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
        consultar = false;
    } 
    
    public void reset () {
        value = new Evento();
    }
    
    public Evento getValue() {
        return value;
    }

    public void setValue(Evento value) {
        this.value = value;
    }

    public List<Evento> getAll() {
        return eventoService.getAll();
    }

    public String save() {
        eventoService.create(value);
        reset();
        return null;
    }

    public String update() {
        eventoService.edit(value);
        return null;
    }

    public String delete() {
        eventoService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Evento> getEventosFiltrados() {
        return eventosFiltrados;
    }

    public void setEventosFiltrados(List<Evento> eventosFiltrados) {
        this.eventosFiltrados = eventosFiltrados;
    }
    
    public SelectItem[] getTipos(boolean filtrar){
        SelectItem[] itens;
        int length = Evento.Tipo.values().length;
        int n = 0;
        if(filtrar) {
            itens = new SelectItem[length + 1];
            itens[0] = new SelectItem("","");
            n++;
        } else itens = new SelectItem[length];
        for(Evento.Tipo tipo : Evento.Tipo.values()){
            itens[n++] = new SelectItem(tipo, tipo.getLabel());
        }
        return itens;
    }
}

