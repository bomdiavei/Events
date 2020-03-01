package beans;

import entities.Atividade;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.AtividadeService;

@Named(value = "atividadeBean")
@ViewScoped
public class AtividadeBean implements Serializable {
    @EJB
    private AtividadeService atividadeService;

    @Inject
    private RequestParameters parameters;

    private Atividade value;
    
    private boolean consultar;
    
    private List<Atividade> atividadesFiltradas;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Atividade();
        else value = atividadeService.find(Long.valueOf(id));
    }
    
    public void consultar (Atividade value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
        consultar = false;
    } 
    
    public void reset () {
        value = new Atividade();
    }
    
    public Atividade getValue() {
        return value;
    }

    public void setValue(Atividade value) {
        this.value = value;
    }

    public List<Atividade> getAll() {
        return atividadeService.getAll();
    }

    public String save() {
        atividadeService.create(value);
        reset();
        return null;
    }

    public String update() {
        atividadeService.edit(value);
        return null;
    }

    public String delete() {
        atividadeService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Atividade> getAtividadesFiltradas() {
        return atividadesFiltradas;
    }

    public void setAtividadesFiltradas(List<Atividade> atividadesFiltradas) {
        this.atividadesFiltradas = atividadesFiltradas;
    }

    public List<Atividade> completaAtividades(String prefixo) {
        return atividadeService.filter(prefixo);
    }
}
