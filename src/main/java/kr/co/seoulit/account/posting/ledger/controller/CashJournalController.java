package kr.co.seoulit.account.posting.ledger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.operate.system.to.AccountEntity;
import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.service.LedgerServiceImpl;
import kr.co.seoulit.account.posting.ledger.to.CashJournalBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/posting")
public class CashJournalController {

	@Autowired
    private LedgerService ledgerService;
	@Autowired
    private DatasetBeanMapper datasetBeanMapper;
    
    
    ModelAndView mav = null;
    ModelMap map = new ModelMap();

    @RequestMapping("/cashjournal")
    public ArrayList<CashJournalBean> handleRequestInternal(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	String account="0101";
    	String fromDate=reqData.getVariable("startDate").getString();
    	String toDate=reqData.getVariable("endDate").getString();
    	System.out.println(account+"@@@@@@@@@@@@@@@@@@");
    	System.out.println(fromDate+"@@@@@@@@@@@@@@@@@@");
    	System.out.println(toDate+"@@@@@@@@@@@@@@@@@@");
        ArrayList<CashJournalBean> cashJournalList = ledgerService.findCashJournal(fromDate, toDate, account);
        datasetBeanMapper.beansToDataset(resData, cashJournalList, CashJournalBean.class);
        return null;
    }
}
