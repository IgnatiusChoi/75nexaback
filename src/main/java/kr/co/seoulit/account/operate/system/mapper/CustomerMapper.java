package kr.co.seoulit.account.operate.system.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;

@Mapper
public interface CustomerMapper {

    public void insertCustomer(CustomerUpdateRequest customerUpdateRequest); //거래처추가

    public void deleteCustomer(String code); //거래처삭제
    
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest); //거래처수정

}
