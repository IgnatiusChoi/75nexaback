package kr.co.seoulit.account.operate.system.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
@Transactional(rollbackFor = {Exception.class})
public class CustomerMRepositoryImpl{

    private final EntityManager em;

    public CustomerMRepositoryImpl(EntityManager em) {
        this.em = em;
    }

}
