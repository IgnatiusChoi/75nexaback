package kr.co.seoulit.account.sys.base.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.sys.base.exception.DeptCodeNotFoundException;
import kr.co.seoulit.account.sys.base.exception.IdNotFoundException;
import kr.co.seoulit.account.sys.base.exception.PwMissmatchException;
import kr.co.seoulit.account.sys.base.to.CodeBean;
import kr.co.seoulit.account.sys.base.to.CustomerEntity;
import kr.co.seoulit.account.sys.base.to.DetailCodeEntity;
import kr.co.seoulit.account.sys.base.to.IreportBean;
import kr.co.seoulit.account.sys.base.to.MenuEntity;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeEntity;

public interface BaseService {

    public EmployeeEntity findLoginData(String empCode, String userPw) throws IdNotFoundException, PwMissmatchException, DeptCodeNotFoundException;

    public ArrayList<MenuEntity> findUserMenuList(String deptCode);
    
    public ArrayList<MenuEntity> selectAllMenuList();

    public ArrayList<DetailCodeEntity> findDetailCodeList(HashMap<String, String> param);

    public ArrayList<DetailCodeEntity> findCodeDetailList();

    public ArrayList<CodeBean> findCodeList();

    public ArrayList<IreportBean> findIreportData(HttpServletRequest request, HttpServletResponse response, String slipNo);

    public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeEntity> codeList2);

	public String findPeriodNo(String today);

	public void registerPeriodNo(String sdate, String edate);

	public void modifyEarlyStatements(String periodNo);
	
	public ArrayList<AuthorityEmpBean> findAuthority(String empCode);
	
	public void findIreportData3(HttpServletRequest request, HttpServletResponse response);
	
	public void findIreportData4(HttpServletRequest request, HttpServletResponse response);

	public void findIreportDataincome(HttpServletRequest request, HttpServletResponse response);
	
	public void findIreportDatafinance(HttpServletRequest request, HttpServletResponse response);
	
	public HashMap<String, String> findUrlMapper();

	public void findIreportTotalData(HttpServletRequest request, HttpServletResponse response);
	
    public ArrayList<CustomerEntity> findCustomerList();


}
