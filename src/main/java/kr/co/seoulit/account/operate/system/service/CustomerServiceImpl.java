package kr.co.seoulit.account.operate.system.service;

import kr.co.seoulit.account.operate.system.mapper.CustomerMapper;
import kr.co.seoulit.account.operate.system.entity.Customer;
import kr.co.seoulit.account.operate.system.repository.CustomerMRepository;
import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerMRepository customerRepository;
    @Autowired
    EntityManager em;
    /*@Autowired
    CustomerMapper customerMapper;*/
    private final CustomerMapper customerDAO;

    public CustomerServiceImpl(CustomerMapper customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> findCustomerList() {
        return customerRepository.findAll();
    }

/*    @Override
    @Transactional
    public void registerCustomer(CustomerUpdateRequest customerUpdateRequest){
//        Customer customerEntity = em.find(Customer.class, customer.getCustomerCode());
//        if (customerEntity.getCustomerCode() == null) {
//            em.persist(customerEntity);
//        }
//        System.out.println(" --------------------");
//        CustomerUpdateRequest customerUpdateRequest = customerMapper.toCustomerDTO(customerEntity);
//        System.out.println(" = ++++++++++");
//        em.persist(customerUpdateRequest);

        Customer customer = customerRepository.findByCustomerCode(customerUpdateRequest.getCustomerCode());
        customer.updateCustomer(customerUpdateRequest.getCustomerCeo());
    }*/

    @Override
    public void registerCustomer(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.insertCustomer(customerUpdateRequest);
    }

    @Override
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.updateCustomer(customerUpdateRequest);
    }

    @Override
    public void removeCustomer(String customerCode) {
        customerDAO.deleteCustomer(customerCode);
        System.out.println("거래처삭제완료 : " + customerCode);
    }

    /*@Override
    public void registerCustomers(CustomerUpdateRequest customerUpdateRequest) {
        customerDAO.insertCustomer(customerUpdateRequest);
    }*/

     /*@Override
     @Transactional
     public void registerCustomers(List<CustomerUpdateRequest> customerUpdateRequestList) {
         List<String> customerCodes = customerUpdateRequestList.stream()
                 .map(CustomerUpdateRequest::getCustomerCode)
                 .collect(Collectors.toList());

         List<Customer> customerList = customerRepository.findAllByCustomerCode(customerCodes);

         customerList.forEach(customer -> customerUpdateRequestList.stream()
                 .filter(updateRequest -> customer.getCustomerCode().equals(updateRequest.getCustomerCode()))
                 .findFirst()
                 .ifPresent(updateRequest -> {
                     customer.updateCustomer(updateRequest.getCustomerCeo());
                     // 필요한 다른 필드도 업데이트 작업 수행 가능
                     // customer.updateXXX(updateRequest.getXXX());
                 }));
     }*/
}
