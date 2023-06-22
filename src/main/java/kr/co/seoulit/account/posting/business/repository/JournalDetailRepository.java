package kr.co.seoulit.account.posting.business.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JournalDetailRepository{

    @PersistenceContext
    EntityManager em;

    public void deleteByJournalNo(String journalNo) {
        em.createQuery("delete from JournalEntity where journalNo = :journalNo")
                .setParameter("journalNo", journalNo).executeUpdate();
    }

    public void saveJournalDetail(JournalDetailEntity journalDetailEntity) {
        em.persist(journalDetailEntity);
    }

    public void saveJournalDetailList(JournalDetailEntity journalDetailEntity) {
        em.remove(journalDetailEntity);
    }

    public void removeJournalDetailByJournalNo(String journalNo) {
        em.createQuery("delete from JournalDetailEntity where journalNo = :journalNo")
                .setParameter("journalNo", journalNo).executeUpdate();
    }

    public void mergeJournalDetail(JournalDetailEntity journalDetailEntity) {
        em.merge(journalDetailEntity);
    }
}
