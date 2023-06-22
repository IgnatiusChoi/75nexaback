package kr.co.seoulit.account.operate.humanresource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.seoulit.account.operate.humanresource.to.EmployeeEntity;

import java.util.ArrayList;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, String> {

    EmployeeEntity findByEmpCode(String empCode);

    ArrayList<EmployeeEntity> findALLByDeptCode(String deptCode);

    void deleteByEmpCode(String empCode);

}
