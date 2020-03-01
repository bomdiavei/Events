
package services;

import entities.Organizador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class OrganizadorService extends EntityService<Organizador> {

    public OrganizadorService() {
        super(Organizador.class);
    }
    
    public List<Organizador> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery("SELECT organizador from Organizador organizador WHERE organizador.nome LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }
    
}
