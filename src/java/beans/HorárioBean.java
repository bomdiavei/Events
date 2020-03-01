package beans;

import entities.Horário;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.HorárioService;

@Named(value = "horárioBean")

@ViewScoped
public class HorárioBean implements Serializable {
    @EJB
    private HorárioService horárioService;

    @Inject
    private RequestParameters parameters;

    private Horário value;
    
    private boolean consultar;
    
    private List<Horário> horáriosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Horário();
        else value = horárioService.find(Long.valueOf(id));
    }
    
    public void consultar (Horário value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
        consultar = false;
    } 
    
    public void reset () {
        value = new Horário();
    }
    
    public Horário getValue() {
        return value;
    }

    public void setValue(Horário value) {
        this.value = value;
    }

    public List<Horário> getAll() {
        return horárioService.getAll();
    }

    public String save() {
        horárioService.create(value);
        reset();
        return null;
    }

    public String update() {
        horárioService.edit(value);
        return null;
    }

    public String delete() {
        horárioService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Horário> getHoráriosFiltradas() {
        return horáriosFiltrados;
    }

    public void setHoráriosFiltradas(List<Horário> horáriosFiltrados) {
        this.horáriosFiltrados = horáriosFiltrados;
    }
    
    public SelectItem[] getTurnos(boolean filtrar){
        SelectItem[] itens;
        int length = Horário.Turno.values().length;
        int n = 0;
        if(filtrar) {
            itens = new SelectItem[length + 1];
            itens[0] = new SelectItem("","");
            n++;
        } else itens = new SelectItem[length];
        for(Horário.Turno turno : Horário.Turno.values()){
            itens[n++] = new SelectItem(turno, turno.getLabel());
        }
        return itens;
    }

}