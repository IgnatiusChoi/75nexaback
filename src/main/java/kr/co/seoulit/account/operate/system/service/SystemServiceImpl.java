package kr.co.seoulit.account.operate.system.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.to.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.operate.system.mapper.AccountSubjectMapper;
import kr.co.seoulit.account.operate.system.mapper.AuthorityGroupMapper;
import kr.co.seoulit.account.operate.system.mapper.BoardMapper;
import kr.co.seoulit.account.operate.system.mapper.WorkplaceMapper;
import kr.co.seoulit.account.operate.system.repository.AccountControlRepository;
import kr.co.seoulit.account.operate.system.repository.AccountRepository;
//import kr.co.seoulit.account.operate.system.repository.WorkplaceRepository;


@Service
@Transactional
public class SystemServiceImpl implements SystemService {

	private final AccountSubjectMapper accountDAO;
	private final AuthorityGroupMapper authorityGroupDAO;
	private final WorkplaceMapper workplaceDAO;
	private final AccountControlRepository accountControlRepository;
	private final AccountRepository accountRepository;
	private final BoardMapper BoardDAO;
	//private final WorkplaceRepository workplaceRepository;

	public SystemServiceImpl(AccountSubjectMapper accountDAO, AuthorityGroupMapper authorityGroupDAO,
							 WorkplaceMapper workplaceDAO, AccountControlRepository accountControlRepository,
							 AccountRepository accountRepository, BoardMapper BoardDAO) {
		this.accountDAO = accountDAO;
		this.authorityGroupDAO = authorityGroupDAO;
		this.workplaceDAO = workplaceDAO;
		this.accountControlRepository = accountControlRepository;
		this.accountRepository = accountRepository;
		this.BoardDAO=BoardDAO;
		//this.workplaceRepository=workplaceRepository;
	}

	@Override
	public ArrayList<AccountEntity> findAccountList() {
		return accountDAO.selectAccountList();
	}

	@Override
	public AccountEntity findAccount(String accountCode) {

		AccountEntity accountEntity = null;
		accountEntity = accountDAO.selectAccount(accountCode);

		return accountEntity;
	}

	@Override
	public ArrayList<AccountEntity> findParentAccountList() {

       	ArrayList<AccountEntity> accountList = null;
      	accountList = accountDAO.selectParentAccountList();

        return accountList;
	//	return (ArrayList<AccountEntity>) accountRepository.findParentAccountList();
	}

	//상세 계정코드 가져오기
	@Override
	public ArrayList<AccountDetailEntity> findDetailAccountList(String parentAccountInnerCode) {

		ArrayList<AccountDetailEntity> accountList = null;
		accountList = accountDAO.selectDetailAccountList(parentAccountInnerCode);

		return accountList;
	}

	@Override
	public void modifyAccount(AccountEntity accountEntity) {

		accountDAO.updateAccount(accountEntity);

	}

	@Override
	public ArrayList<AccountEntity> findAccountListByName(String accountName) {

//		ArrayList<AccountEntity> accountList = null;
//		accountList = accountDAO.selectAccountListByName(accountName);
//
//		return accountList;
		return (ArrayList<AccountEntity>) accountRepository.findAccountListByName(accountName);
	}

	@Override
	public ArrayList<AccountControlEntity> findAccountControlList(String accountCode) {

		ArrayList<AccountControlEntity> accountControlList = null;
		accountControlList = accountDAO.selectAccountControlList(accountCode);

		return accountControlList;
	}

	public ArrayList<AccountControlEntity> findAccountDetailList() {
		return (ArrayList<AccountControlEntity>) accountControlRepository.findAll();

	}

	@Override
	public ArrayList<AccountEntity> findDetailBudgetList(String code) {
		// TODO Auto-generated method stub

		ArrayList<AccountEntity> budgetList = null;
		budgetList = accountDAO.selectDetailBudgetList(code);

		return budgetList;
	}

	@Override
	public ArrayList<AccountEntity> findParentBudgetList() {
		// TODO Auto-generated method stub

		ArrayList<AccountEntity> parentBudgetList = null;
		parentBudgetList = accountDAO.selectParentBudgetList();

		return parentBudgetList;
	}

	@Override
	public ArrayList<PeriodEntity> findAccountPeriodList() {
		// TODO Auto-generated method stub

		ArrayList<PeriodEntity> accountPeriodList = null;
		accountPeriodList = accountDAO.selectAccountPeriodList();

		return accountPeriodList;
	}
	@Override
	public ArrayList<PeriodEntity> findPeriodList() {
		// TODO Auto-generated method stub
		ArrayList<PeriodEntity> PeriodList = null;
		PeriodList = accountDAO.selectPeriodList();

		return PeriodList;
	}

	@Override
	public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode) {

		ArrayList<AuthorityEmpBean> authorityEmp = null;
		authorityEmp = authorityGroupDAO.selectAuthorityEmp(deptCode);

		return authorityEmp;
	}

	@Override
	public void modifyAuthorityGroup(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept) {

		for (AuthorityEmpBean bean : authorityEmpBean) {
			authorityGroupDAO.updateAuthorityGroup(bean, dept);
		}
	}

	@Override
	public ArrayList<AuthorityMenuEntity> findAuthorityGroup() {

		ArrayList<AuthorityMenuEntity> authorityGroup = null;
		authorityGroup = authorityGroupDAO.selectAuthorityGroup();

		return authorityGroup;
	}

	@Override
	public void addAuthorityGroup(String addAuthority, String nextGroupCode) {

		authorityGroupDAO.insertAuthorityGroup(addAuthority, nextGroupCode);

	}

	@Override
	public ArrayList<AuthorityEmpBean> findAuthorityGroupCode() {

		ArrayList<AuthorityEmpBean> findAuthorityGroupCode = null;
		findAuthorityGroupCode = authorityGroupDAO.selectAuthorityGroupCode();

		return findAuthorityGroupCode;
	}

	@Override
	public void removeAuthorityGroup(String groupCode) {

		authorityGroupDAO.deleteAuthorityGroup(groupCode);
		authorityGroupDAO.deleteAuthorityMenu(groupCode);

	}

	@Override
	public ArrayList<AuthorityMenuEntity> findAuthorityMenu(String menuName) {

		HashMap<String, String> map = new HashMap<>();
		map.put("menuName", menuName);
		ArrayList<AuthorityMenuEntity> authorityMenu = null;
		authorityMenu = authorityGroupDAO.selectAuthorityMenu(map);

		return authorityMenu;
	}

	@Override
	public void modifyAuthorityMenu(ArrayList<AuthorityMenuEntity> authorityMenuEntity, String dept) {

		for (AuthorityMenuEntity bean : authorityMenuEntity) {
			authorityGroupDAO.updateAuthorityMenu(bean, dept);
		}

	}

	public ArrayList<AuthorityMenuEntity> findEmpAuthorityList(String empCode) {
		ArrayList<AuthorityMenuEntity> empAuthorityList = authorityGroupDAO.selectEmpAuthorityMenu(empCode);
		for (AuthorityMenuEntity a : empAuthorityList) {
			System.out.println(a.getIsAuthority());
		}
		return empAuthorityList;
	}

	@Override
	public void registerWorkplace(WorkplaceEntity workplaceEntity) {

		//WorkplaceEntity workplaceCodeCheck = customerDAO.selectWorkplace(workplaceEntity.getWorkplaceCode());
		//if (workplaceCodeCheck == null) {
		//	System.out.println("workplaceBean : " + workplaceEntity);
		//}
	workplaceDAO.insertWorkplace(workplaceEntity);
	}

	@Override
	public void removeWorkplace(String workplaceCode) {

			workplaceDAO.deleteWorkplace(workplaceCode);
			System.out.println("사업장삭제완료:" + workplaceCode);
		}


	@Override
	public void modifyApprovalStatus(ArrayList<String> getCodes, String status) {

		for (String code : getCodes) {
			workplaceDAO.updateWorkplaceAccount(code, status);

		}
	}

	@Override
	public WorkplaceEntity findWorkplace(String workplaceCode) {

		WorkplaceEntity workplaceEntity = null;
		workplaceEntity = workplaceDAO.selectWorkplace(workplaceCode);

		return workplaceEntity;
	}

	@Override
	public ArrayList<WorkplaceEntity> findAllWorkplaceList() {

		System.out.println("@@@@SystemServiceImpl@@@@");
		ArrayList<WorkplaceEntity> allworkplaceList = workplaceDAO.selectAllWorkplaceList();

		return allworkplaceList;
		//return ( ArrayList<WorkplaceEntity>) workplaceRepository.findAll();
	}

	@Override
	public ArrayList<BusinessBean> findBusinessList() {

		ArrayList<BusinessBean> businessList = null;
		businessList = workplaceDAO.selectBusinessList();

		return businessList;
	}

	@Override
	public ArrayList<DetailBusinessBean> findDetailBusiness(String businessCode) {

		ArrayList<DetailBusinessBean> detailBusinessList = null;
		detailBusinessList = workplaceDAO.selectDetailBusinessList(businessCode);

		return detailBusinessList;
	}
	@Override
	public void insertBoard(BoardBean bean) {

		BoardDAO.insertBoard(bean);

	}
	@Override
	public void updateBoard(BoardBean bean) {

		BoardDAO.updateBoard(bean);

	}
	@Override
	public ArrayList<BoardBean> selectBoardList(){
		return (ArrayList<BoardBean>) BoardDAO.selectBoardList();
	}
	public ArrayList<BoardBean> selectBoarddetail(String row){

		return (ArrayList<BoardBean>) BoardDAO.selectBoarddetail(row);
	}

	@Override
	public void removeBoard() {

		BoardDAO.deleteBoard();

	}
}
