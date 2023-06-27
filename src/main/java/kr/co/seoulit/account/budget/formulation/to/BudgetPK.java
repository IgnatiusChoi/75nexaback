package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class BudgetPK implements Serializable {

	@Column(name="ACCOUNT_INNER_CODE")
	public String accountInnerCode;
	@Column(name="DEPT_CODE")
	public String deptCode;
	@Column(name="WORKPLACE_CODE")
	public String workplaceCode;
	@Column(name="ACCOUNT_PERIOD_NO")
	public String accountPeriodNo;
	@Column(name="BUDGETING_CODE", columnDefinition = "char")
	public String budgetingCode;

	public BudgetPK() {
	}

	@Builder
	public BudgetPK(String accountInnerCode, String deptCode, String workplaceCode, String accountPeriodNo, String budgetingCode) {
		this.accountInnerCode = accountInnerCode;
		this.deptCode = deptCode;
		this.workplaceCode = workplaceCode;
		this.accountPeriodNo = accountPeriodNo;
		this.budgetingCode = budgetingCode;
	}
}
