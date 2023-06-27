package kr.co.seoulit.account.budget.formulation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import kr.co.seoulit.account.budget.formulation.to.*;
import org.modelmapper.ModelMapper;
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


		System.out.println(" WWW");
    	 ArrayList<BudgetCodeBean> bean = formulationService.findBudgetCode();
  		  datasetBeanMapper.beansToDataset(resData, bean, BudgetCodeBean.class);

    	return null;
    }

    @RequestMapping("/batch")
    public void batchBudget(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData")PlatformData resData) throws Exception {
		System.out.println(" batatchcsc");


 		 String deptCode = reqData.getVariable("deptCode").getString();
 		 String workplaceCode=reqData.getVariable("workplaceCode").getString();
 		 String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
 		 String budgetingCode=reqData.getVariable("budgetingCode").getString();
 		 String accountInnerCode=reqData.getVariable("accountInnerCode").getString();

    	BudgetBean obj = datasetBeanMapper.datasetToBean(reqData,BudgetBean.class);
    	obj.setDeptCode(deptCode);
    	obj.setWorkplaceCode(workplaceCode);
    	obj.setAccountPeriodNo(accountPeriodNo);
    	obj.setBudgetingCode(budgetingCode);
    	obj.setAccountInnerCode(accountInnerCode);

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
	@RequestMapping("/budgetListForComp")
	public BudgetRequest budgetListForComp(@RequestAttribute("reqData") PlatformData reqData,
													   @RequestAttribute("resData")PlatformData resData) throws Exception {

		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		String budgetingCode=reqData.getVariable("budgetingCode").getString();


		BudgetRequest budgetRequest = new BudgetRequest(deptCode, workplaceCode, accountPeriodNo, accountInnerCode, budgetingCode);

		BudgetRequest result = formulationService.budgetListForComp(budgetRequest);

		datasetBeanMapper.beanToDataset(resData, result, BudgetRequest.class);

		return null;

	}

	 @RequestMapping("/compBudget")
	 public ArrayList<BudgetRequest> compBudget(@RequestAttribute("reqData") PlatformData reqData,
												 @RequestAttribute("resData")PlatformData resData) throws Exception {

		 String deptCode=reqData.getVariable("deptCode").getString();
		 String workplaceCode=reqData.getVariable("workplaceCode").getString();
		 String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		 String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		 String budgetingCode=reqData.getVariable("budgetingCode").getString();
		 String originBudgetingCode="1";

		 BudgetRequest updateRequest = datasetBeanMapper.datasetToBean(reqData, BudgetRequest.class);
		 updateRequest.setAccountInnerCode(accountInnerCode);
		 updateRequest.setAccountPeriodNo(accountPeriodNo);
		 updateRequest.setDeptCode(deptCode);
		 updateRequest.setWorkplaceCode(workplaceCode);
		 updateRequest.setBudgetingCode(budgetingCode);

		 BudgetRequest originRequest = new BudgetRequest(deptCode, workplaceCode, accountPeriodNo, accountInnerCode, originBudgetingCode);

		 BudgetRequest result = formulationService.compBudget(originRequest, updateRequest);

		 datasetBeanMapper.beanToDataset(resData, result, BudgetRequest.class);

		 return null;
	 }

	@RequestMapping("/budgetListForRecon")
	public ArrayList<BudgetRequestForRecon> budgetListForRecon(@RequestAttribute("reqData") PlatformData reqData,
															   @RequestAttribute("resData")PlatformData resData) throws Exception {
		String deptCode=reqData.getVariable("deptCode").getString();
		String workplaceCode=reqData.getVariable("workplaceCode").getString();
		String accountPeriodNo=reqData.getVariable("accountPeriodNo").getString();
		String accountInnerCode=reqData.getVariable("accountInnerCode").getString();
		String budgetingCode=reqData.getVariable("budgetingCode").getString();


		BudgetRequestForRecon budgetRequestForRecon = new BudgetRequestForRecon(deptCode, workplaceCode, accountPeriodNo, accountInnerCode, budgetingCode);

		BudgetRequestForRecon result = formulationService.budgetRequestForRecon(budgetRequestForRecon);

		datasetBeanMapper.beanToDataset(resData, result, BudgetRequestForRecon.class);

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
