package kr.co.seoulit.account.posting.ledger.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.*;

@Data
@Dataset(name="gds_customerLedger")
public class CustomerLedgerBean extends BaseBean {

    private int carryOver;
    private String customerCode;
    private String customerName;
    private int deposit;
    private int withdrawal;
    private int balance;
}
