package kr.co.seoulit.account.settlement.monthIncomeStatement.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;


@Data
@Dataset(name = "ds_monthIncomeStatement")
public class MonthIncomeStatementBean extends BaseBean {

    private String year;
    private String month;
    private String salesSummary;
    private String salesCostSummary;
    private String grossMargin;
    private String salesManageCostSummary;
    private String operatingProfit;
    private String nonOperatingProfitSummary;
    private String nonOperatingCostSummary;
    private String ordinaryProfit;
    private String corporateTaxSummary;
    private String netIncome;
}
