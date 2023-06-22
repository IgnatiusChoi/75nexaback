package kr.co.seoulit.account.posting.ledger.controller;


import com.tobesoft.xplatform.data.PlatformData;
import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.to.CustomerLedgerBean;
import kr.co.seoulit.account.posting.ledger.to.CustomerLedgerDetailBean;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
@RequestMapping("/posting")
public class CustomerLedgerController {

    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @Autowired
    public CustomerLedgerController(LedgerService ledgerService,DatasetBeanMapper datasetBeanMapper) {
        this.ledgerService=ledgerService;
        this.datasetBeanMapper=datasetBeanMapper;
    }


    @RequestMapping("/customerledger")
    public void handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
                                                            @RequestAttribute("resData") PlatformData resData) throws Exception{

        String fromDate=reqData.getVariable("startDate").getString();
        String toDate=reqData.getVariable("endDate").getString();

        ArrayList<CustomerLedgerBean> customerLedgerList = ledgerService.findCustomerLedger(fromDate, toDate);
        System.out.println("%%%%%%%"+customerLedgerList.get(0).getCustomerName());
        datasetBeanMapper.beansToDataset(resData, customerLedgerList, CustomerLedgerBean.class);

    }

    @RequestMapping("/findCustomerLedgerDetailList")
    public void findJournalDetailList(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception{

        String customerCode=reqData.getVariable("customerCode").getString();

        ArrayList<CustomerLedgerDetailBean> customerLedgerDetailList = ledgerService.findCustomerLedgerDetailList(customerCode);
        //System.out.println("%%%%%%%"+customerLedgerDetailList.get(0).getReportingDate());
        datasetBeanMapper.beansToDataset(resData, customerLedgerDetailList, CustomerLedgerDetailBean.class);

    }
}
