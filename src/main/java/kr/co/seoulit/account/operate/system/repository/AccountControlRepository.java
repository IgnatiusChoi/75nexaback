package kr.co.seoulit.account.operate.system.repository;

import kr.co.seoulit.account.operate.system.to.AccountControlEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountControlRepository extends CrudRepository<AccountControlEntity, String> {

}
