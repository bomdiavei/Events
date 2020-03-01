package entities;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voluntário implements Serializable, PersistentEntity {

    public enum EstadoCivil {
        solteiro("solteiro"), casado("casado"), divorciado("divorciado"), viúvo("viúvo");
        private final String label;
        private EstadoCivil(String label) { this.label = label; }
        public String getLabel() { return this.label; }
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome,cpf,rg,sexo;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    
    @OneToOne(cascade = CascadeType.ALL) 
    private Endereço endereço;
    
//    @OneToMany(mappedBy = "voluntário", cascade = CascadeType.REMOVE)
//    private List<Alocação> alocações;
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Voluntário)) {
            return false;
        }
        Voluntário other = (Voluntário) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereço getEndereço() {
        if(endereço == null) endereço = new Endereço();
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }
    
    @Override
    public String toString() {
        //return "entities.Voluntário[ id=" + id + " ]";
        return  getNome() + " - " + 
                getCpf();
    }
    
}