package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name = "ds_budgetComparison")
@NoArgsConstructor
public class BudgetComparisonBean extends BaseBean{
    private String budgetDate;
    private String appBudget;
    private String orgBudget;
    private String execPerform;
    private String budgetAccountComparison;

}
