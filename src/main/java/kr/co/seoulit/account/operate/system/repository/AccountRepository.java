package kr.co.seoulit.account.operate.system.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.operate.system.to.AccountEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public AccountEntity findByCode(String accountCode) {
        return em.find(AccountEntity.class, accountCode);
    }

    public List<AccountEntity> findParentAccountList() {
        return em.createQuery("select a from AccountEntity a " +
                        "where a.accountInnerCode " +
                        "LIKE '%-%' and a.parentAccountInnerCode NOT IN (:text)" +
                        "ORDER BY a.accountInnerCode", AccountEntity.class)
                .setParameter("text", Arrays.asList("0101-1000", "0101-0250"))
                .getResultList(); //JPQL
    }

    public List<AccountEntity> findDetailAccountList(String parentAccountInnerCode) {
        return em.createQuery("select a from AccountEntity a " +
                        "where a.accountInnerCode NOT like '%-%' AND a.parentAccountInnerCode = :text " +
                        "ORDER BY a.accountInnerCode", AccountEntity.class)
                .setParameter("text", parentAccountInnerCode)
                .getResultList();
    }

    public List<AccountEntity> findAccountListByName(String accountName) {
        accountName = "%"+accountName+"%";
        return em.createQuery("select a from AccountEntity a where a.accountName LIKE :text and a.accountCode NOT IN ('%-%') and a.accountName <> '사용자설정계정과목' order by a.accountCode", AccountEntity.class)
                .setParameter("text", accountName)
                .getResultList();
    }

    public List<AccountEntity> findDetailBudgetList(String accountCode) {
        return em.createQuery("select a from AccountEntity a " +
                        "where a.accountInnerCode not like '%-%' " +
                        "and a.parentAccountInnerCode = :text " +
                        "and a.budget = 'T' " +
                        "order by a.accountInnerCode", AccountEntity.class)
                .setParameter("text", accountCode)
                .getResultList();
    }
}