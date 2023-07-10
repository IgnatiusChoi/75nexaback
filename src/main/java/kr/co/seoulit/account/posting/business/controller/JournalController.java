package kr.co.seoulit.account.posting.business.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import kr.co.seoulit.account.sys.common.util.BeanCreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/posting")
public class JournalController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;


    //@GetMapping("/singlejournallist")
    @RequestMapping("/findSingleJournalList")
    public ArrayList<JournalEntity> findSingleJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData")PlatformData resData) throws Exception {
        String slipNo = reqData.getVariable("slipNo").getString();
        ArrayList<JournalEntity> journalList = businessService.findSingleJournalList(slipNo);
        datasetBeanMapper.beansToDataset(resData, journalList, JournalEntity.class);
        return null;
//        ArrayList<JournalEntity> journalList = businessService.findSingleJournalList(slipNo);
//
//        return journalList;
    }

    @RequestMapping(value = "/findRangedJournalList")
    public ArrayList<JournalEntity> findRangedJournalList(@RequestAttribute("reqData") PlatformData reqData,
                                                          @RequestAttribute("resData")PlatformData resData) throws Exception {
        String fromDate = reqData.getVariable("startDate").getString();
        String toDate = reqData.getVariable("endDate").getString();

        ArrayList<JournalEntity> journalList = businessService.findRangedJournalList(fromDate,toDate);
        datasetBeanMapper.beansToDataset(resData, journalList, JournalEntity.class);
        return null;
    }

    @GetMapping("/journalremoval")
    public void removeJournal(@RequestParam String journalNo) {


        businessService.removeJournal(journalNo);

    }
    @GetMapping("modifyJournal")
    public void modifyJournal(@RequestParam String slipNo,
                              @RequestParam JSONArray journalObj) {

        JSONArray journalObjs = JSONArray.fromObject(journalObj);

        ArrayList<JournalEntity> journalBeanList = new ArrayList<>();

        for (Object journalObjt : journalObjs) {
            JournalEntity journalEntity = BeanCreator.getInstance().create(JSONObject.fromObject(journalObjt), JournalEntity.class);
            journalEntity.setStatus(((JSONObject)journalObjt).getString("status"));
            journalBeanList.add(journalEntity);
        }
        businessService.modifyJournal(slipNo, journalBeanList);

    }

}
