package kr.co.seoulit.account.operate.system.repository;

import kr.co.seoulit.account.operate.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerMRepository extends JpaRepository<Customer, Long> {


    Customer findByCustomerCode(String CustomerCode);

    @Query("SELECT c FROM Customer c WHERE c.customerCode IN :customerCodeList")
    List<Customer> findAllByCustomerCode(@Param("customerCodeList") List<String> customerCodeList);
}
