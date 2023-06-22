package kr.co.seoulit.account.posting.ledger.to;


import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.*;

@Data
@Dataset(name="gds_customerLedger_detail")
public class CustomerLedgerDetailBean extends BaseBean {

    private String reportingDate;
    private String accountName;
    private int leftDebtorPrice;
    private int rightCreditsPrice;
}
