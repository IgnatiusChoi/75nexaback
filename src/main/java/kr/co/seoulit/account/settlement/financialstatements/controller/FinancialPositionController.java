package kr.co.seoulit.account.settlement.financialstatements.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.settlement.financialstatements.service.FinancialStatementsService;
import kr.co.seoulit.account.settlement.financialstatements.to.FinancialPositionBean;
import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;
import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/settlement")
public class FinancialPositionController {

	 @Autowired
    private FinancialStatementsService financialStatementsService;
	 @Autowired
	 private DatasetBeanMapper datasetBeanMapper;
		@Autowired
		private BaseService baseService;
	
  
	 @RequestMapping("/financialposition")
    public HashMap<String, Object> handleRequestInternal( @RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {

			String accountPeriodNo=reqData.getVariable("period").getString();
			String callResult=reqData.getVariable("callresult").getString();
			
    	HashMap<String, Object> params = new HashMap<>();
    	params.put("accountPeriodNo",accountPeriodNo);
    	params.put("callResult",callResult);
    	
    	financialStatementsService.findFinancialPosition(params);
    	
    	ArrayList<FinancialPositionBean> bean = (ArrayList<FinancialPositionBean>) params.get("financialPosition");
    	
    	datasetBeanMapper.beansToDataset(resData, bean, FinancialPositionBean.class);
       
        return null;
    }

		@RequestMapping("/selectfinancialposition")
		public HashMap<String,Object> SelectFinancialposition( @RequestAttribute("reqData") PlatformData reqData,
				@RequestAttribute("resData") PlatformData resData) throws Exception {
			
			String date=reqData.getVariable("date").getString();
			String callResult=reqData.getVariable("callresult").getString();

			// date로 값받아올때 ex) 20170717 이런식으로 받아와서 -> 2017-07-17 이런식으로 값을 바꿔줌
			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(5, 7);
			
			String ddate = year +"-"+month+"-"+day;
			
			String accountPeriodNo = baseService.findPeriodNo(ddate);
			 
			HashMap<String,Object> params = new HashMap<>();
			params.put("accountPeriodNo",accountPeriodNo);
			params.put("callResult",callResult);
			//TotalTrialBalanceBean bean=(TotalTrialBalanceBean)trialBalanceService.findTotalTrialBalance(params).get("totalTrialBalanceResult");
			financialStatementsService.findFinancialPosition(params);
			System.out.println("@@@@@@@@@@@@@@@"+params);
			ArrayList<FinancialPositionBean> bean = (ArrayList<FinancialPositionBean>) params.get("financialPosition");
		  datasetBeanMapper.beansToDataset(resData, bean, FinancialPositionBean.class);
	        
	          
	        return null;

		}
}