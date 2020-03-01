package beans;

import entities.Alocação;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.AlocaçãoService;

@Named(value = "alocaçãoBean")
@ViewScoped
public class AlocaçãoBean implements Serializable {
    @EJB
    private AlocaçãoService alocaçãoService;
    
    @Inject
    private RequestParameters parameters;

    private Alocação value;
    
    private boolean consultar;
    
    private List<Alocação> alocaçõesFiltradas;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Alocação();
        else value = alocaçãoService.find(Long.valueOf(id));
    }
    
    public void consultar (Alocação value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
        consultar = false;
    } 
    
    public void reset () {
        value = new Alocação();
    }
    
    public Alocação getValue() {
        return value;
    }

    public void setValue(Alocação value) {
        this.value = value;
    }

    public List<Alocação> getAll() {
        return alocaçãoService.getAll();
    }

    public String save() {
        alocaçãoService.create(value);
        reset();
        return null;
    }

    public String update() {
        alocaçãoService.edit(value);
        return null;
    }

    public String delete() {
        alocaçãoService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Alocação> getAlocaçõesFiltradas() {
        return alocaçõesFiltradas;
    }

    public void setAlocaçõesFiltradas(List<Alocação> alocaçõesFiltradas) {
        this.alocaçõesFiltradas = alocaçõesFiltradas;
    }
}

