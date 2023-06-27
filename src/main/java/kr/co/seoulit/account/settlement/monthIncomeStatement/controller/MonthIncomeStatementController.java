package kr.co.seoulit.account.settlement.monthIncomeStatement.controller;

import kr.co.seoulit.account.settlement.monthIncomeStatement.service.MonthIncomeStatementService;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settlement")
public class MonthIncomeStatementController {

    @Autowired
    private MonthIncomeStatementService monthIncomeStatementService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    //월별손익계산서 조회
//    @RequestMapping("/monthIncomeStatement")
//    public ArrayList<MonthIncomeStatementBean> monthIncomeStatement(@RequestAttribute("reqData") PlatformData reqData,
//                                                         @RequestAttribute("resData") PlatformData resData) throws Exception {
//
//        String fromDate = reqData.getVariable("startDate").getString();
//        String toDate = reqData.getVariable("endDate").getString();
//
//        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementService.findMonthIncomeStatement(fromDate, toDate);
//        datasetBeanMapper.beansToDataset(resData, monthIncomeStatementList, MonthIncomeStatementBean.class);
//        return null;
//    }
}
