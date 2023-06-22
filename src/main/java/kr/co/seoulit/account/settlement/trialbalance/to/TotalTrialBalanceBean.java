package kr.co.seoulit.account.settlement.trialbalance.to;

import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset( name = "ds_totaltrialbalance")
public class TotalTrialBalanceBean {

    private int lev;
    private String accountName;
    private String accountInnerCode;
    private long debitsSumBalance;
    private long debitsSum;
    private long creditsSum;
    private long creditsSumBalance;

}
