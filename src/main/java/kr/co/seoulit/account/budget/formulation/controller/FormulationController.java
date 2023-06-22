package kr.co.seoulit.account.budget.formulation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import kr.co.seoulit.account.sys.common.util.BeanCreator;

import kr.co.seoulit.account.budget.formulation.service.FormulationService;

import kr.co.seoulit.account.budget.formulation.to.BudgetBean;
import kr.co.seoulit.account.budget.formulation.to.BudgetCodeBean;
import kr.co.seoulit.account.budget.formulation.to.BudgetStatusBean;
import kr.co.seoulit.account.posting.business.to.JournalEntity;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/budget")
public class FormulationController{
	
	@Autowired
	private FormulationService formulationService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	BeanCreator beanCreator  = BeanCreator.getInstance();

    @GetMapping("/budget")
	 public BudgetBean findBudget(@RequestParam String budgetObj) {

		 JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);
		
   
	        return formulationService.findBudget(budgetBean);
	 }
    
    @RequestMapping("/budgetcode")
    public ArrayList<BudgetCodeBean> findBudgetCode(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData")PlatformData resData) throws Exception {
    	
    	 ArrayList<BudgetCodeBean> bean = formulationService.findBudgetCode();
  		  datasetBeanMapper.beansToDataset(resData, bean, BudgetCodeBean.class);
    	
    	return null;
    }

    @RequestMapping("/batch")
    public void batchBudget(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData")PlatformData resData) throws Exception {
 		 String budgetCode = reqData.getVariable("budgetCode").getString();
 		 String period=reqData.getVariable("period").getString();
    	
    	BudgetBean obj = datasetBeanMapper.datasetToBean(reqData,BudgetBean.class);
    	obj.setAccountPeriodNo(period);
    	obj.setBudgetCode(budgetCode);
    	
    	formulationService.batchBudgetCode(obj);
    	
    }
    
    @RequestMapping("/formationbudgetlist")
    public void formationBudget(@RequestAttribute("reqData") PlatformData reqData,
    		@RequestAttribute("resData")PlatformData resData) throws Exception {
    	String budgetCode=reqData.getVariable("budgetCode").getString();
 		 String budgetingCode=reqData.getVariable("budgetingCode").getString();
    	
 		 HashMap<String, String> map=new HashMap<String, String>();
    	map.put("budgetCode", budgetCode);
    	map.put("budgetingCode", budgetingCode);
 		  ArrayList<BudgetBean> bean =  formulationService.formationBudget(map);
   		  datasetBeanMapper.beansToDataset(resData, bean, BudgetBean.class);
    }
    
    @RequestMapping("/budgetlist")
	 public ArrayList<BudgetBean>  findBudgetList(@RequestAttribute("reqData") PlatformData reqData,
	            @RequestAttribute("resData")PlatformData resData) throws Exception {
	      		 String budgetCode = reqData.getVariable("budgetCode").getString();
	      		 String budgetingCode=reqData.getVariable("budgetingCode").getString();
	      		 
	      		 HashMap<String,String> map = new HashMap<String, String>();
	      		 map.put("budgetCode", budgetCode);
	      		 map.put("budgetingCode", budgetingCode);
	   		  ArrayList<BudgetBean> bean =  formulationService.findBudgetList(map);

	   		  datasetBeanMapper.beansToDataset(resData, bean, BudgetBean.class);
	   		  
		 return null;
   
	 }
    @GetMapping("/budgetstatus")
	 public Vector<BudgetStatusBean> findBudgetStatus(@RequestParam String budgetObj) {
	       	 
    	JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);
		Vector<BudgetStatusBean> beans=formulationService.findBudgetStatus(budgetBean);
		
	        return beans;
	 }
    @RequestMapping(value = "/budgetappl", method = RequestMethod.POST)
	 public ArrayList<BudgetBean> findBudgetAppl(@RequestParam String budgetObj) {
		   
		 
		 JSONObject budgetJsonObj = JSONObject.fromObject(budgetObj); //예산
		 BudgetBean budgetBean =beanCreator.create(budgetJsonObj, BudgetBean.class);
	
		  return null;
	 }
}
