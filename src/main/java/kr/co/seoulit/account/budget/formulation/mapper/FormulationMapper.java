package kr.co.seoulit.account.budget.formulation.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.budget.formulation.to.BudgetBean;
import kr.co.seoulit.account.budget.formulation.to.BudgetCodeBean;
import kr.co.seoulit.account.budget.formulation.to.BudgetStatusBean;

@Mapper
public interface FormulationMapper {

	public BudgetBean selectBudget(BudgetBean bean);

	public ArrayList<BudgetBean> selectBudgetList(HashMap<String,String> map);

	public ArrayList<BudgetBean>  selectBudgetAppl(BudgetBean bean);

	public ArrayList<BudgetCodeBean>  selectBudgetCode();

	public void selectBudgetStatus(HashMap<String, Object> map);

	public void batchBudgetCode(BudgetBean obj);

	public void formationBudget(HashMap<String, String> map);

	void selectComparisonBudget(HashMap<String, Object> map);
}
