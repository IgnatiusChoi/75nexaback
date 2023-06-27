package kr.co.seoulit.account.budget.formulation.Repository;

import kr.co.seoulit.account.budget.formulation.to.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.to.BudgetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface BudgetRepository extends JpaRepository<BudgetEntity, String>, BudgetCustomRepository{

    @Override
    BudgetEntity findByBudgetRequest(@Param("budgetEntity") BudgetEntity budgetEntity);
}
