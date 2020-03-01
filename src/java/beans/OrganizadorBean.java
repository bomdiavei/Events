package beans;

import entities.Organizador;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.OrganizadorService;

@Named(value = "organizadorBean")
@ViewScoped
public class OrganizadorBean implements Serializable {
    @EJB
    private OrganizadorService organizadorService;

    @Inject
    private RequestParameters parameters;

    private Organizador value;
    
    private boolean consultar;
    
    private List<Organizador> organizadoresFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Organizador();
        else value = organizadorService.find(Long.valueOf(id));
    }
    
    public void consultar (Organizador value) {
        setValue(value); 
        consultar = true;
    }
    
    public void inserir() {
        reset();
    }
    
    public void reset () {
        value = new Organizador();
    }
    
    public Organizador getValue() {
        return value;
    }

    public void setValue(Organizador value) {
        this.value = value;
    }

    public List<Organizador> getAll() {
        return organizadorService.getAll();
    }

    public String save() {
        organizadorService.create(value);
        reset();
        return null;
    }

    public String update() {
        organizadorService.edit(value);
        return null;
    }

    public String delete() {
        organizadorService.remove(value);
        return null;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Organizador> getOrganizadoresFiltrados() {
        return organizadoresFiltrados;
    }

    public void setOrganizadoresFiltrados(List<Organizador> organizadoresFiltrados) {
        this.organizadoresFiltrados = organizadoresFiltrados;
    }
    
    public List<Organizador> completaOrganizadores(String prefixo) {
        return organizadorService.filter(prefixo);
    }


}
