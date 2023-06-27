package kr.co.seoulit.account.budget.formulation.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name = "ds_budgetListForRecon")
@NoArgsConstructor
public class BudgetRequestForRecon extends BaseBean{

	private String accountInnerCode;
	private String deptCode;
	private String workplaceCode;
	private String accountPeriodNo;
	private String budgetingCode;
	private String m1Budget;
	private String m2Budget;
	private String m3Budget;
	private String m4Budget;
	private String m5Budget;
	private String m6Budget;
	private String m7Budget;
	private String m8Budget;
	private String m9Budget;
	private String m10Budget;
	private String m11Budget;
	private String m12Budget;

	@Builder
	public BudgetRequestForRecon(String deptCode, String workplaceCode, String accountPeriodNo, String accountInnerCode, String budgetingCode) {
		this.deptCode = deptCode;
		this.workplaceCode = workplaceCode;
		this.accountPeriodNo = accountPeriodNo;
		this.accountInnerCode = accountInnerCode;
		this.budgetingCode = budgetingCode;
	}

	@Builder
	public BudgetEntity toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		BudgetEntity budgetEntity = modelMapper.map(this, BudgetEntity.class);
		budgetEntity.setBudgetPK(
				BudgetPK.builder()
						.accountInnerCode(accountInnerCode)
						.deptCode(deptCode)
						.workplaceCode(workplaceCode)
						.accountPeriodNo(accountPeriodNo)
						.budgetingCode(budgetingCode)
						.build()
		);

		return budgetEntity;
	}


	public static BudgetRequestForRecon fromEntity(BudgetEntity budgetEntity){
		ModelMapper modelMapper = new ModelMapper();
		BudgetRequestForRecon budgetRequestForRecon = modelMapper.map(budgetEntity, BudgetRequestForRecon.class);

		budgetRequestForRecon.setAccountInnerCode(budgetEntity.budgetPK.accountInnerCode);
		budgetRequestForRecon.setAccountPeriodNo(budgetEntity.budgetPK.accountPeriodNo);
		budgetRequestForRecon.setBudgetingCode(budgetEntity.budgetPK.budgetingCode);
		budgetRequestForRecon.setDeptCode(budgetEntity.budgetPK.deptCode);
		budgetRequestForRecon.setWorkplaceCode(budgetEntity.budgetPK.workplaceCode);
		return budgetRequestForRecon;
	}
}
