package kr.co.seoulit.account.operate.system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import kr.co.seoulit.account.operate.system.service.SystemService;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.operate.system.to.AuthorityMenuEntity;

@RestController
@RequestMapping("/operate")
public class AuthorityController {

	private SystemService systemService;
	private DatasetBeanMapper datasetBeanMapper;

    @Autowired
	public AuthorityController(SystemService systemService, DatasetBeanMapper datasetBeanMapper) {
		this.systemService=systemService;
		this.datasetBeanMapper=datasetBeanMapper;
		
	}
    /* nexacro */
    @RequestMapping(value = "/loginAuthority")
    public void loginAuthority(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData)throws Exception{
        String empCode = reqData.getVariable("empCode").getString();
        ArrayList<AuthorityMenuEntity> authorityList = systemService.findEmpAuthorityList(empCode);
        datasetBeanMapper.beansToDataset(resData, authorityList, AuthorityMenuEntity.class);
    }

    @GetMapping("/authorityemp")
    public ArrayList<AuthorityEmpBean> findAuthorityEmp(@RequestParam String deptCode) {
       
        	
            ArrayList<AuthorityEmpBean> authorityEmp = systemService.findAuthorityEmp(deptCode);
           
        return authorityEmp;
    }
	
	@GetMapping("/authoritygroupmodification")
    public void modifyAuthorityGroup(@RequestParam String authority,
    								 @RequestParam String deptCode) {
        
     
        	Gson gson = new Gson();
			ArrayList<AuthorityEmpBean> authorityEmpBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityEmpBean>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityGroup(authorityEmpBean , deptCode);
           
 
    }
	@GetMapping("/authoritygroupcode")
    public ArrayList<AuthorityEmpBean> findAuthorityGroupCode() {
      
        	
            ArrayList<AuthorityEmpBean> findAuthorityGroupCode = systemService.findAuthorityGroupCode();
   
        return findAuthorityGroupCode;
    }

	@GetMapping("/additionauthoritygroup")
    public void addAuthorityGroup(@RequestParam String addAuthority,
			 							  @RequestParam String nextGroupCode) {
       
        	
		systemService.addAuthorityGroup(addAuthority,nextGroupCode);
             
        
    }

	@GetMapping("/authoritygroupremoval")
    public void removeAuthorityGroup(@RequestParam String groupCode) {
       
        	
		systemService.removeAuthorityGroup(groupCode);

    }
	@GetMapping("/authoritygroup")
    public ArrayList<AuthorityMenuEntity> findAuthorityGroup() {
     
            ArrayList<AuthorityMenuEntity> authorityGroup = systemService.findAuthorityGroup();
   
        return authorityGroup;
    }

	@GetMapping("/authoritymenu")
    public ArrayList<AuthorityMenuEntity> findAuthorityMenu(@RequestParam String menuName) {

            ArrayList<AuthorityMenuEntity> authorityMenu = systemService.findAuthorityMenu(menuName);

        return authorityMenu;
    }

	@GetMapping("/authoritymenumodification")
    public void modifyAuthorityMenu(@RequestParam String authority,@RequestParam String deptCode) {
        
  
        	Gson gson = new Gson();
			ArrayList<AuthorityMenuEntity> authorityMenuBean = gson.fromJson(authority,
					new TypeToken<ArrayList<AuthorityMenuEntity>>() {
					}.getType());
        	
            	
			systemService.modifyAuthorityMenu(authorityMenuBean , deptCode);
       
    }
}
