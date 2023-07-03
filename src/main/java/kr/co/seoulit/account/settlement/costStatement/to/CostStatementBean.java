package kr.co.seoulit.account.settlement.costStatement.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Dataset(name = "ds_tmpCostStatement")
@Table(name = "TMP_COST_STATEMENT")
@Getter
@Setter
public class CostStatementBean extends BaseBean {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_INNER_CODE")
    private String accountInnerCode;

    @Column(name = "ACCOUNT_NAME", columnDefinition = "NVARCHAR2")
    private String accountName;

    @Column(name = "PARENT_ACCOUNT_CODE")
    private String parentAccountCode;

    @Column(name = "COST", columnDefinition = "NUMBER")
    private String cost;

    @Column(name = "COST_SUMMARY", columnDefinition = "NUMBER")
    private String costSummary ;

    private String earlyCost;
    private String earlyCostSummary;
    private String isThisYear;

}
