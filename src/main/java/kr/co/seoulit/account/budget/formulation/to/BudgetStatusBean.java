package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name = "ds_budgetStatus")
@NoArgsConstructor
public class BudgetStatusBean extends BaseBean{
    private String accountInnerCode;
    private String accountName;
    private long ABR;//연간 예산 실적
    private long annualBudget;
    private long remainingBudget;
    private double budgetExecRate;//집행률
    private long AMBR;
    private long Budget;
    private long remainingMonthBudget;
    private double monthBudgetExecRate;//집행률

}
