package services;

import entities.Atividade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class AtividadeService extends EntityService<Atividade> {

    public AtividadeService() {
        super(Atividade.class);
    }
    
    public List<Atividade> filter(String prefix) {
        prefix += "%";
        Query query = em.createQuery("SELECT atividade from Atividade atividade WHERE atividade.função LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }
}