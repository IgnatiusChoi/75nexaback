package kr.co.seoulit.account.budget.formulation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import kr.co.seoulit.account.budget.formulation.to.*;

public interface FormulationService {

	public BudgetBean findBudget(BudgetBean bean);

	public ArrayList<BudgetBean> findBudgetList(HashMap<String,String> map);

	public BudgetRequest budgetListForComp(BudgetRequest budgetRequest);
	public BudgetRequestForRecon budgetRequestForRecon(BudgetRequestForRecon budgetRequestForRecon);

	public void compBudget(BudgetRequest updateRequest);
	public void reconBudget(BudgetRequestForRecon updateRequest);

	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean);

	public ArrayList<BudgetStatusBean> findBudgetStatus(BudgetBean bean);

	public ArrayList<BudgetComparisonBean> findBudgetComparison(BudgetBean bean);

	public ArrayList<BudgetCodeBean> findBudgetCode();

	public void batchBudgetCode(BudgetBean obj);

	public ArrayList<BudgetBean> formationBudget(HashMap<String, String> map);

}
