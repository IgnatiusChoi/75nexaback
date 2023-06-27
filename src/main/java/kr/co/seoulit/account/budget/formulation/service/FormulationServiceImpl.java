package kr.co.seoulit.account.budget.formulation.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Vector;

import kr.co.seoulit.account.budget.formulation.Repository.BudgetRepository;
import kr.co.seoulit.account.budget.formulation.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.budget.formulation.mapper.FormulationMapper;

import javax.persistence.EntityManager;

@Service
@Transactional
public class FormulationServiceImpl implements FormulationService {

	@Autowired
	private FormulationMapper formulationDAO;
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	private EntityManager em;

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
		System.out.println("000000000");
		BudgetEntity budgetEntity = budgetRequestForRecon.toEntity();
		System.out.println("budgetEntity11 = " + budgetEntity.toString());
		BudgetEntity findBudgetEntity = budgetRepository.findByBudgetRequest(budgetEntity);
		System.out.println("findBudgetEntity11 = " + findBudgetEntity);

		return BudgetRequestForRecon.fromEntity(findBudgetEntity);
	}

	@Override
	public BudgetRequest compBudget(BudgetRequest originRequest, BudgetRequest updateRequest) {

		BudgetEntity originEntity = originRequest.toEntity();
		BudgetEntity updateEntity = updateRequest.toEntity();

		BudgetEntity findBudgetEntity = budgetRepository.findByBudgetRequest(originEntity);
		BudgetEntity findEmEntity = em.find(findBudgetEntity.getClass(), findBudgetEntity.budgetPK);

		findEmEntity.budgetPK.setBudgetingCode(updateRequest.getBudgetingCode());
		for (int i = 1; i <= 12; i++) {
			String fieldName = "m" + i + "Budget";
			try {
				Field field = BudgetEntity.class.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object value = field.get(updateEntity);
				field.set(findEmEntity, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		em.persist(findEmEntity);
		return null;
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
	public Vector<BudgetStatusBean> findBudgetStatus(BudgetBean bean) {
		// TODO Auto-generated method stub

		Vector<BudgetStatusBean> beans = null;
		beans = formulationDAO.selectBudgetStatus(bean);

		return beans;
	}

	@Override
	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean) {
		// TODO Auto-generated method stub

			return formulationDAO.selectBudgetAppl(bean);

	}
}
