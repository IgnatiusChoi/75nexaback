package kr.co.seoulit.account.settlement.trialbalance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.settlement.trialbalance.to.TotalTrialBalanceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.settlement.trialbalance.service.TrialBalanceService;
import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;



@RestController
@RequestMapping("/settlement")
public class DetailTrialBalanceController {
	@Autowired
    private TrialBalanceService trialBalanceService;
	@Autowired
    private DatasetBeanMapper datasetBeanMapper;
    
	@RequestMapping("/detailtrialbalance")
    public HashMap<String,Object> handleRequestInternal(@RequestAttribute("reqData")PlatformData reqData,
            @RequestAttribute("resData")PlatformData resData) throws Exception {


        String fromDate = reqData.getVariable("startDate").getString();
        String toDate = reqData.getVariable("endDate").getString();

        HashMap<String, Object> params=new HashMap<>();
        params.put("fromDate", fromDate);
        params.put("toDate", toDate);
        trialBalanceService.findDetailTrialBalance(params);
        ArrayList<DetailTrialBalanceBean>  bean = (ArrayList<DetailTrialBalanceBean>) params.get("RESULT");
        datasetBeanMapper.beansToDataset(resData, bean, DetailTrialBalanceBean.class);

        return null;
    }
	
}
