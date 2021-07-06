package com.company.shopr.repositories;

import com.company.shopr.domain.Game;
import com.company.shopr.domain.Lp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LpRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Lp> getLps() {
        List<Lp> lpList = entityManager.createQuery("select lp from Lp lp order by lp.title , lp.producer, lp.price", Lp.class).getResultList();
        return lpList;
    }

    @Transactional
    public void addLp(Lp newLp) {
        entityManager.persist(newLp);
    }

    @Transactional
    public void updateLp(Lp newLp) {
        entityManager.merge(newLp);
    }

    @Transactional
    public Lp findLpById(long lpId){
        return entityManager.find(Lp.class, lpId);
    }

    @Transactional
    public void editLpById(Lp editedLp) { entityManager.merge(editedLp); }

    @Transactional
    public void removeLp(long id) {Lp lp = findLpById(id);entityManager.remove(lp); }
}
