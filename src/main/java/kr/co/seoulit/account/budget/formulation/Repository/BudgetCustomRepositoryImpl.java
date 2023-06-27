package kr.co.seoulit.account.budget.formulation.Repository;

import kr.co.seoulit.account.budget.formulation.to.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.to.BudgetRequest;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetCustomRepositoryImpl implements BudgetCustomRepository {

    @Override
    public BudgetEntity findByBudgetRequest(BudgetEntity budgetEntity) {

        return null;
    }
}
