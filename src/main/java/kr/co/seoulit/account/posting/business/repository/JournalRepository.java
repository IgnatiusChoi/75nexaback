package kr.co.seoulit.account.posting.business.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JournalRepository {

    @PersistenceContext
    EntityManager em;

    public void removeByJournalNo(String journalNo) {
        em.createQuery("delete from JournalEntity where journalNo = :journalNo")
                .setParameter("journalNo", journalNo).executeUpdate();
    }
/*
    public void persistJournalEntity(JournalEntity journalEntity) {
        mergeJournalEntity(journalEntity);
    }

    public void mergeJournalEntity(JournalEntity journalEntity) {
        em.merge(journalEntity);
    }
*/
    public void removeBySlipNo(String slipNo) {
        em.createQuery("delete from JournalEntity where slipNo = :slipNo")
                .setParameter("slipNo", slipNo).executeUpdate();
    }
}
