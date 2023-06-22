package kr.co.seoulit.account.settlement.financialstatements.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_financialposition")
public class FinancialPositionBean extends BaseBean {
    private int lev;
    private String category;
    private String accountName;
    private String accountCode;
    private int balanceDetail;
    private long balanceSummary;
    private int preBalanceDetail;
    private int preBalanceSummary;
    private int isThisYear;

}
