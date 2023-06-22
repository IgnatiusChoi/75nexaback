package kr.co.seoulit.account.operate.humanresource.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.operate.humanresource.service.HumanResourceService;

import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeEntity;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/operate")
public class HRController {

    private HumanResourceService humanResourceService;
    private DatasetBeanMapper datasetBeanMapper;
    @Autowired
    public HRController(HumanResourceService humanResourceService, DatasetBeanMapper datasetBeanMapper) {
    	this.humanResourceService=humanResourceService;
    	this.datasetBeanMapper=datasetBeanMapper;
    }

    ModelAndView mav;
    ModelMap map = new ModelMap();
    
    @GetMapping("/employeelist")
	public ArrayList<EmployeeEntity> findEmployeeList(@RequestParam String deptCode) {

            ArrayList<EmployeeEntity> empList = humanResourceService.findEmployeeList(deptCode);
            return empList;
   }
    
    @RequestMapping(value="/saveEmpImg",method={RequestMethod.GET, RequestMethod.POST})
    public void saveEmpImg(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	
    		String image = reqData.getVariable("image").getString(); 
    		String empCode = reqData.getVariable("empCode").getString(); 
    		System.out.println("image    :"+image);
    		System.out.println("empCode    :"+empCode);
    		HashMap<String, String> map = new HashMap<>();
    		map.put("image", image);
    		map.put("empCode", empCode);
            humanResourceService.saveEmpImg(map);
          
     
    }
    
    /* nexacro */
  @RequestMapping("/findEmployeeList" )
  public ArrayList<EmployeeEntity> findEmployeeList(@RequestAttribute("reqData") PlatformData reqData,
                                                    @RequestAttribute("resData") PlatformData resData) throws Exception{
      //ArrayList<EmployeeEntity> empList= hrServiceFacade.findEmployeeList(deptCode);
      ArrayList<EmployeeEntity> empList= humanResourceService.findEmployeeList();
      datasetBeanMapper.beansToDataset(resData, empList, EmployeeEntity.class);
      return null;
  }
    
    @GetMapping("/employeeListall")
    public ArrayList<EmployeeEntity> findEmployeeListAll() {

            ArrayList<EmployeeEntity> empList = humanResourceService.findEmployeeList();
            
            return empList;
    }

    @GetMapping("/employee")
    public EmployeeEntity findEmployee(@RequestParam String empCode) {

            EmployeeEntity employeeEntity = humanResourceService.findEmployee(empCode);

            return employeeEntity;
    }

    @GetMapping("/batchempinfo")
    public void batchEmpInfo(@RequestParam String employeeInfo,@RequestParam String image) {
      
            JSONObject jsonObject = JSONObject.fromObject(employeeInfo);
         
            EmployeeEntity employeeEntity = (EmployeeEntity) JSONObject.toBean(jsonObject, EmployeeEntity.class);
            employeeEntity.setImage(image);
            humanResourceService.batchEmployeeInfo(employeeEntity);
           
           
    }

    @GetMapping("/emptyempbean")
    public ModelAndView EmptyEmpBean(HttpServletRequest request, HttpServletResponse response) {
       
        return null;
    }

    @GetMapping("/batchemp")
    public void batchEmp(@RequestParam String JoinEmployee) {
     
            JSONObject jsonObject = JSONObject.fromObject(JoinEmployee);
            
            EmployeeEntity employeeEntity = (EmployeeEntity) JSONObject.toBean(jsonObject, EmployeeEntity.class);

            humanResourceService.registerEmployee(employeeEntity);
          
    }
    
    @RequestMapping("/deleteEmployee")
    public void removeEmployee(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	String empCode = reqData.getVariable("empCode").getString();
    	
           
//            EmployeeEntity employeeEntity = new EmployeeEntity();
//            employeeEntity.setEmpCode(empCode);
            humanResourceService.removeEmployee(empCode);
          
     
    }
    @GetMapping("/deptlist")
    public ArrayList<DepartmentBean> findDeptList() {
       
            ArrayList<DepartmentBean> deptList = humanResourceService.findDeptList();
         
        return deptList;
    }
    
    @RequestMapping("/selectworkplaceCode")
    public ArrayList<DepartmentBean> selectworkplaceCode(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{

            ArrayList<DepartmentBean> workplaceList = humanResourceService.selectworkplaceCode();
            datasetBeanMapper.beansToDataset(resData, workplaceList, DepartmentBean.class);
        
        return null;
    }
    @RequestMapping("/selectdeptCode")
    public ArrayList<DepartmentBean> selectdeptCode(@RequestAttribute("reqData") PlatformData reqData,
    		@RequestAttribute("resData") PlatformData resData) throws Exception{
    		String code=reqData.getVariable("code").getString();
    	
    	ArrayList<DepartmentBean> deptList = humanResourceService.selectdeptCode(code);
    	datasetBeanMapper.beansToDataset(resData, deptList, DepartmentBean.class);
    	
    	return null;
    }

    public ArrayList<DepartmentBean> findDeptList2() {
        
   	 ArrayList<DepartmentBean> deptList = humanResourceService.findDeptList2();
        
       return deptList;
   }
}
