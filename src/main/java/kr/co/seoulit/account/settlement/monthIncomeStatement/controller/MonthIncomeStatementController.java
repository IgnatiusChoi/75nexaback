package kr.co.seoulit.account.settlement.monthIncomeStatement.controller;


import com.tobesoft.xplatform.data.PlatformData;
import kr.co.seoulit.account.settlement.monthIncomeStatement.service.MonthIncomeStatementService;
import kr.co.seoulit.account.settlement.monthIncomeStatement.to.MonthIncomeStatementBean;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/settlement")
public class MonthIncomeStatementController {

    @Autowired
    private MonthIncomeStatementService monthIncomeStatementService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    //월별손익계산서 조회
    @RequestMapping("/monthIncomeStatement")
    public ArrayList<MonthIncomeStatementBean> monthIncomeStatement(@RequestAttribute("reqData") PlatformData reqData,
                                                                    @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println("월별손익계산서_Controller");
        String selectedDate=reqData.getVariable("selectedDate").getString();
        System.out.println("selectedDate : " + selectedDate);

        HashMap<String,Object> params = new HashMap<>();
        params.put("selectedDate",selectedDate);

        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementService.findMonthIncomeStatement(params);
        datasetBeanMapper.beansToDataset(resData, monthIncomeStatementList, MonthIncomeStatementBean.class);
        return null;



//        String selectedDate = reqData.getVariable("selectedDate").getString();
//        System.out.println("date : " + selectedDate);
//
//        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementService.findMonthIncomeStatement(selectedDate);
//        datasetBeanMapper.beansToDataset(resData, monthIncomeStatementList, MonthIncomeStatementBean.class);
//        return null;
    }

//    @RequestMapping("/monthIncomeStatement")
//    public ArrayList<MonthIncomeStatementBean> monthIncomeStatement(@RequestAttribute("reqData") PlatformData reqData,
//                                                                    @RequestAttribute("resData") PlatformData resData) throws Exception {
//
//        String fromDate = reqData.getVariable("startDate").getString();
//        String toDate = reqData.getVariable("endDate").getString();
//
//        System.out.println("monthIncomeStatement_Controller" + "startDate : " + fromDate + "endDate : " + toDate);
//
//        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementService.findMonthIncomeStatement(fromDate, toDate);
//        //datasetBeanMapper.beansToDataset(resData, monthIncomeStatementList, MonthIncomeStatementBean.class);
//        return null;
//    }
}
