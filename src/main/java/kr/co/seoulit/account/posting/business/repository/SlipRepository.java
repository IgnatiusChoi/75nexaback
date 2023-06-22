package kr.co.seoulit.account.posting.business.repository;

import org.springframework.stereotype.Repository;

import kr.co.seoulit.account.posting.business.to.SlipEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class SlipRepository {

    @PersistenceContext
    EntityManager em;

    public Long countByDate(String slipNoDate) {
        return (Long) em.createQuery("SELECT count(s) from SlipEntity s where s.slipNo like :slipNoDate")
                .setParameter("slipNoDate", slipNoDate).getSingleResult();
    }

    public void persistSlip(SlipEntity slipEntity) {
        em.persist(slipEntity);
    }

    public void removeBySlipNo(String slipNo) {
        em.createQuery("delete from SlipEntity s where s.slipNo = :slipNo")
                .setParameter("slipNo", slipNo).executeUpdate();
    }

    public void mergeSlip(SlipEntity slipEntity) {
        em.merge(slipEntity);
    }

    public ArrayList<SlipEntity> findAllByDate(String slipDate) {
        return (ArrayList<SlipEntity>) em.createQuery("select s from SlipEntity s where s.reportingDate = :slipDate")
                .setParameter("slipDate", slipDate)
                .getResultList();
    }

    public ArrayList<SlipEntity> findAllByStatus(String status) {
        return (ArrayList<SlipEntity>) em.createQuery("select s from SlipEntity s where s.slipStatus = :status")
                .setParameter("status", status)
                .getResultList();
    }

    public SlipEntity findById(String slipNo) {
        return em.find(SlipEntity.class, slipNo);
    }
    /*
    @Query("SELECT count(s) from SlipEntity s where s.slipNo like %:text%")
    Integer countByDate(@Param("text") String today);

    @Query("select s from SlipEntity s where s.reportingDate = :text")
    ArrayList<SlipEntity> findByDate(@Param("text") String reportingDate);

    @Query("select s from SlipEntity s where s.slipStatus = :text")
    ArrayList<SlipEntity> findByStatus(@Param("text") String slipStatus);

    void deleteBySlipNo(String slipNo);
    */


}