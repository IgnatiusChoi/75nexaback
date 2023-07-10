package kr.co.seoulit.account.operate.system.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.system.to.*;

public interface SystemService {

    public AccountEntity findAccount(String code);

    public ArrayList<AccountEntity> findParentAccountList();

	//상세 계정코드 가져오기
    public ArrayList<AccountDetailEntity> findDetailAccountList(String parentAccountInnerCode);

    public void modifyAccount(AccountEntity accountEntity);

    public ArrayList<AccountEntity>findAccountList();

    ArrayList<AccountEntity> findAccountListByName(String accountName);

    ArrayList<AccountControlEntity> findAccountControlList(String accountCode);

    public ArrayList<AccountControlEntity> findAccountDetailList();

    public ArrayList<AccountEntity> findDetailBudgetList(String code);

    public ArrayList<AccountEntity> findParentBudgetList();

    public ArrayList<PeriodEntity> findAccountPeriodList();

    //periodpopup
    public ArrayList<PeriodEntity>  findPeriodList();

    public ArrayList<AuthorityEmpBean> findAuthorityEmp(String deptCode);

    public ArrayList<AuthorityMenuEntity> findEmpAuthorityList(String empCode);

	public void modifyAuthorityGroup(ArrayList<AuthorityEmpBean> authorityEmpBean, String dept);

	public ArrayList<AuthorityMenuEntity> findAuthorityGroup();

	public ArrayList<AuthorityMenuEntity> findAuthorityMenu(String menuName);

	public void addAuthorityGroup(String addAuthority,String nextGroupCode);

	public ArrayList<AuthorityEmpBean> findAuthorityGroupCode();

	public void modifyAuthorityMenu(ArrayList<AuthorityMenuEntity> authorityMenuEntity, String dept);

	public void removeAuthorityGroup(String groupCode);

	public ArrayList<BusinessBean> findBusinessList(); //�뾽�깭醫낅ぉ �쟾遺�議고쉶

	public ArrayList<DetailBusinessBean> findDetailBusiness(String businessName); // �뾽�깭醫낅ぉ �냼遺꾨쪟 �쟾遺�議고쉶

	public WorkplaceEntity findWorkplace(String workplaceCode); // 1媛쒖궗�뾽�옣 議고쉶

	public void registerWorkplace(WorkplaceEntity workplaceEntity); //�궗�뾽�옣異붽�

	public void removeWorkplace(String workplaceCode); //�궗�뾽�옣�궘�젣 //arraylist濡� 諛붽�爰쇱엫

	public void modifyApprovalStatus(ArrayList<String> getCodes,String status); //�궗�뾽�옣 �듅�씤�긽�깭 �뾽�뜲�씠�듃

	public ArrayList<WorkplaceEntity> findAllWorkplaceList(); //紐⑤뱺�궗�뾽�옣議고쉶

	public ArrayList<BoardBean> selectBoardList();

	public ArrayList<BoardBean> selectBoarddetail(String row);

	public void insertBoard(BoardBean bean);

	public void updateBoard(BoardBean bean);

	public void removeBoard();
}
