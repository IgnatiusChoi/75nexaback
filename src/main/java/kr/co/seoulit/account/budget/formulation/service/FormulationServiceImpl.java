package kr.co.seoulit.account.budget.formulation.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import kr.co.seoulit.account.budget.formulation.Repository.BudgetRepository;
import kr.co.seoulit.account.budget.formulation.to.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.budget.formulation.mapper.FormulationMapper;

import javax.persistence.EntityManager;

@Service
@Transactional
public class FormulationServiceImpl implements FormulationService {


	private FormulationMapper formulationDAO;

	private BudgetRepository budgetRepository;

	private EntityManager em;


	public FormulationServiceImpl(FormulationMapper formulationDAO, BudgetRepository budgetRepository, EntityManager em) {
		this.formulationDAO = formulationDAO;
		this.budgetRepository = budgetRepository;
		this.em = em;
	}


	@Override
	public BudgetBean findBudget(BudgetBean bean) {
		// TODO Auto-generated method stub

			bean = formulationDAO.selectBudget(bean);

		return bean;
	}

	@Override
	public ArrayList<BudgetBean>  findBudgetList(HashMap<String,String> map) {
		// TODO Auto-generated method stub


			return formulationDAO.selectBudgetList(map);

	}

	@Override
	public BudgetRequest budgetListForComp(BudgetRequest budgetRequest) {

		BudgetEntity budgetEntity = budgetRequest.toEntity();
		BudgetEntity findBudgetEntity = budgetRepository.findByBudgetRequest(budgetEntity);

		return BudgetRequest.fromEntity(findBudgetEntity);
	}

	@Override
	public BudgetRequestForRecon budgetRequestForRecon(BudgetRequestForRecon budgetRequestForRecon) {
		BudgetEntity budgetEntity = budgetRequestForRecon.toEntity();
		BudgetEntity findBudgetEntity = budgetRepository.findByBudgetRequest(budgetEntity);

		return BudgetRequestForRecon.fromEntity(findBudgetEntity);
	}

	@Override
	public void compBudget(BudgetRequest updateRequest) {

		BudgetEntity updateEntity = updateRequest.toEntity();

		BudgetEntity findEmEntity = em.find(updateEntity.getClass(), updateEntity.budgetPK);

		if (findEmEntity != null) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(updateEntity, findEmEntity);
			em.persist(findEmEntity);
		}
		else {
			em.persist(updateEntity);
		}
	}

	@Override
	public void reconBudget(BudgetRequestForRecon updateRequest) {
		BudgetEntity updateEntity = updateRequest.toEntity();

		BudgetEntity findEmEntity = em.find(updateEntity.getClass(), updateEntity.budgetPK);
		if (findEmEntity != null) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(updateEntity, findEmEntity);
			em.persist(findEmEntity);
		}
		else {
			em.persist(updateEntity);
		}
	}

	@Override
	public ArrayList<BudgetCodeBean> findBudgetCode(){
		// TODO Auto-generated method stub


		return formulationDAO.selectBudgetCode();

	}
	public void batchBudgetCode(BudgetBean obj) {

		formulationDAO.batchBudgetCode(obj);
	}
	public ArrayList<BudgetBean>  formationBudget(HashMap<String, String> map) {

		formulationDAO.formationBudget(map);
		return formulationDAO.selectBudgetList(map);
	}

	@Override
	public ArrayList<BudgetStatusBean> findBudgetStatus(BudgetBean bean) {
		// TODO Auto-generated method stub

		HashMap<String, Object> map = new HashMap<>();
		map.put("accountPeriodNo", bean.getAccountPeriodNo());
		map.put("deptCode", bean.getDeptCode());
		map.put("workplaceCode", bean.getWorkplaceCode());
		formulationDAO.selectBudgetStatus(map);
		ArrayList<BudgetStatusBean> result = (ArrayList<BudgetStatusBean>) map.get("RESULT");
		return result;
	}

	@Override
	public ArrayList<BudgetComparisonBean> findBudgetComparison(BudgetBean bean) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("accountPeriodNo", bean.getAccountPeriodNo());
		map.put("deptCode", bean.getDeptCode());
		map.put("workplaceCode", bean.getWorkplaceCode());
		map.put("accountInnerCode", bean.getAccountInnerCode());

		formulationDAO.selectComparisonBudget(map);
		ArrayList<BudgetComparisonBean> result = (ArrayList<BudgetComparisonBean>) map.get("RESULT");
		return result;
	}

	@Override
	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean) {
		// TODO Auto-generated method stub

			return formulationDAO.selectBudgetAppl(bean);

	}
}
