package kr.co.seoulit.account.operate.humanresource.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeEntity;

public interface HumanResourceService {

    public ArrayList<EmployeeEntity> findEmployeeList(String deptCode);
    
    public ArrayList<EmployeeEntity> findEmployeeList();

    public EmployeeEntity findEmployee(String empCode);

    public void batchEmployeeInfo(EmployeeEntity employeeEntity);

    public void batchEmployee(ArrayList<EmployeeEntity> empList);

    public void registerEmployee(EmployeeEntity employeeEntity);
    
    public void removeEmployee(String empCode);
	
	public ArrayList<DepartmentBean> findDeptList();
	
	public ArrayList<DepartmentBean> findDeptList2();

	public ArrayList<DepartmentBean> selectworkplaceCode();
	
	public ArrayList<DepartmentBean> selectdeptCode(String code);
	
	public void modifyImage(String newFileName);

	public EmployeeEntity findImage(String EMP_CODE);
	
	 public void saveEmpImg(HashMap<String,String> map);
}
