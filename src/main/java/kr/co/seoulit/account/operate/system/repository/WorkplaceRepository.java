package kr.co.seoulit.account.operate.system.repository;

import org.springframework.stereotype.Repository;
import kr.co.seoulit.account.operate.system.to.WorkplaceEntity;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface WorkplaceRepository extends CrudRepository<WorkplaceEntity,String> {

}
