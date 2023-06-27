package kr.co.seoulit.account.settlement.costStatement.controller;

import kr.co.seoulit.account.settlement.costStatement.service.CostStatementService;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settlement")
public class CostStatementController {

    @Autowired
    private CostStatementService costStatementService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    //원가명세서 조회
//    @RequestMapping(value = "/costStatement")
//    public ArrayList<CostStatementBean> findCostStatement(@RequestAttribute("reqData") PlatformData reqData,
//                                                          @RequestAttribute("resData")PlatformData resData) throws Exception {
//        String date = reqData.getVariable("date").getString();
//
//        ArrayList<CostStatementBean> costStatementList = costStatementService.findCostStatement(date);
//        datasetBeanMapper.beansToDataset(resData, costStatementList, CostStatementBean.class);
//        return null;
//    }

}
