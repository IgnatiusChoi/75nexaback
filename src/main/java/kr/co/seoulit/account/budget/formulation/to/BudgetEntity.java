package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="BUDGET")
@NoArgsConstructor
public class BudgetEntity extends BaseBean {

	@EmbeddedId
	public BudgetPK budgetPK;

	@Column(name = "M1_BUDGET")
	private Integer m1Budget;
	@Column(name = "M2_BUDGET")
	private Integer m2Budget;
	@Column(name = "M3_BUDGET")
	private Integer m3Budget;
	@Column(name = "M4_BUDGET")
	private Integer m4Budget;
	@Column(name = "M5_BUDGET")
	private Integer m5Budget;
	@Column(name = "M6_BUDGET")
	private Integer m6Budget;
	@Column(name = "M7_BUDGET")
	private Integer m7Budget;
	@Column(name = "M8_BUDGET")
	private Integer m8Budget;
	@Column(name = "M9_BUDGET")
	private Integer m9Budget;
	@Column(name = "M10_BUDGET")
	private Integer m10Budget;
	@Column(name = "M11_BUDGET")
	private Integer m11Budget;
	@Column(name = "M12_BUDGET")
	private Integer m12Budget;

	@Builder
	public BudgetEntity(String accountInnerCode, String deptCode, String workplaceCode, String accountPeriodNo, String budgetingCode) {
		this.budgetPK = new BudgetPK(accountInnerCode, deptCode, workplaceCode, accountPeriodNo, budgetingCode);
	}


}
