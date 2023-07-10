package kr.co.seoulit.account.settlement.monthIncomeStatement.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Dataset(name = "ds_tmpmonthIncomeStatement")
@Table(name = "TMP_MONTH_INCOME_STATEMENT2")
@Getter @Setter
public class MonthIncomeStatementBean extends BaseBean {

    @Column(name = "YEAR")
    private String year;

    @Id
    @Column(name = "MONTH")
    private String month;

    @Column(name = "SALES_SUMMARY", columnDefinition = "number")
    private String salesSummary;

    @Column(name = "SALES_COST_SUMMARY", columnDefinition = "number")
    private String salesCostSummary;

    @Column(name = "GROSS_MARGIN", columnDefinition = "number")
    private String grossMargin;

    @Column(name = "SALES_MANAGE_COST_SUMMARY", columnDefinition = "number")
    private String salesManageCostSummary;

    @Column(name = "OPERATING_PROFIT", columnDefinition = "number")
    private String operatingProfit;

    @Column(name = "NON_OPERATING_PROFIT_SUMMARY", columnDefinition = "number")
    private String nonOperatingProfitSummary;

    @Column(name = "NON_OPERATING_COST_SUMMARY", columnDefinition = "number")
    private String nonOperatingCostSummary;

    @Column(name = "ORDINARY_PROFIT", columnDefinition = "number")
    private String ordinaryProfit;

    @Column(name = "CORPORATE_TAX_SUMMARY", columnDefinition = "number")
    private String corporateTaxSummary;

    @Column(name = "NET_INCOME", columnDefinition = "number")
    private String netIncome;
}
