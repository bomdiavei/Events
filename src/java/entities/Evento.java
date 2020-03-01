package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Evento implements Serializable, PersistentEntity {
    
    public enum Tipo {
        encontro("encontro"), clínica("clínica"), refeição_beneficente("refeição beneficente"), escola_bíblica("escola bíblica");
        private final String label;
        private Tipo(String label) { this.label = label; }
        public String getLabel() { return this.label; }
    };

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String título;
    
    private int ano;
    
    private Tipo tipo;
    
    
    @ManyToOne private Horário horário;
    @ManyToOne private Organizador organizador;
    @ManyToMany private List<Atividade> atividades;
//    @OneToMany(mappedBy = "evento") private List<Alocação> alocações;
    
    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Horário getHorário() {
        if(horário == null) horário = new Horário();
        return horário;
    }

    public void setHorário(Horário horário) {
        this.horário = horário;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entities.Evento[ id=" + id + " ]";
        return título;
    }
    
}