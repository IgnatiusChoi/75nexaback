package kr.co.seoulit.account.posting.ledger.mapper;


import kr.co.seoulit.account.posting.ledger.to.CustomerLedgerBean;
import kr.co.seoulit.account.posting.ledger.to.CustomerLedgerDetailBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CustomerLedgerMapper {

   public ArrayList<CustomerLedgerBean> selectCustomerLedgerList(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

   public ArrayList<CustomerLedgerDetailBean> selectCustomerLedgerDetailList(String customerCode);
}
