package kr.co.seoulit.account.posting.business.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.posting.business.DTO.JournalDto;
import kr.co.seoulit.account.posting.business.DTO.SlipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.business.service.BusinessService;
import kr.co.seoulit.account.posting.business.service.BusinessServiceImpl;
import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;
import kr.co.seoulit.account.posting.business.to.SlipEntity;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import kr.co.seoulit.account.sys.common.util.BeanCreator;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import com.google.gson.Gson;
import com.tobesoft.xplatform.data.PlatformData;

@RestController
@RequestMapping("/posting")
public class SlipController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;


    ModelAndView mav = null;
    ModelMap map = new ModelMap();
    /* nexacro */
    @RequestMapping("/addSlip")
    public void addSlip(@RequestAttribute("reqData") PlatformData reqData,
                        @RequestAttribute("resData") PlatformData resData) throws Exception{
        // 넘어온 dataset 데이터를 Bean객체로 파싱
        SlipEntity slipObj = datasetBeanMapper.datasetToBean(reqData, SlipEntity.class); // 전표추가는 한번에 하나 가능
        System.out.println("분개 받아오기");
        ArrayList<JournalEntity> journal = (ArrayList<JournalEntity>)datasetBeanMapper.datasetToBeans(reqData, JournalEntity.class); // 분개
        System.out.println("addSlip 실행");
        ArrayList<JournalDetailEntity> journalDetail = (ArrayList<JournalDetailEntity>)datasetBeanMapper.datasetToBeans(reqData, JournalDetailEntity.class);

        String empCode = reqData.getVariable("empCode").getString();
        String deptCode = reqData.getVariable("deptCode").getString();

        slipObj.setReportingEmpCode(empCode);
        slipObj.setDeptCode(deptCode);
        slipObj.setSlipStatus("승인요청");

        businessService.addSlip(slipObj, journal, journalDetail);//journalDetail
    }

    /* nexacro */
    @RequestMapping("/updateSlip")
    public void modifySlip(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println(reqData);
        SlipDto slipdto= datasetBeanMapper.datasetToBean(reqData, SlipDto.class);
        ArrayList<JournalDto> journalObj=(ArrayList<JournalDto>)datasetBeanMapper.datasetToBeans(reqData, JournalDto.class);
        String slipStatus=slipdto.getSlipStatus();

        Gson gson = new Gson();
        JSONObject slipJson = JSONObject.fromObject(slipdto); //전표
        JSONArray journalJson = JSONArray.fromObject(journalObj); //분개
        ArrayList<JournalDto> journaldtos = new ArrayList<>();
        for (Object journal : journalJson) {
            JournalDto journaldto = gson.fromJson(journal.toString(), JournalDto.class);

            journaldto.setSlipNo(slipdto.getSlipNo());
            journaldtos.add(journaldto);
        }
        if(slipStatus.equals("승인요청")) {
            slipdto.setSlipStatus("승인요청");
        }else if(slipStatus.equals("작성중(반려)")){
            slipdto.setSlipStatus("승인요청");
        }
        System.out.println("전달테스트");
        businessService.modifySlip(slipdto, journaldtos);
    }
    @RequestMapping(value="/registerslip")
    public void registerSlip(@RequestParam(value="slipObj",required=false) String slipObj,
                             @RequestParam(value="journalObj",required=false) String journalObj,
                             @RequestParam(value="slipStatus",required=false) String slipStatus) {

        Gson gson = new Gson();
        SlipDto slipEntity = gson.fromJson(slipObj, SlipDto.class);
        JSONArray journalObjs = JSONArray.fromObject(journalObj);
        /*
         * slipBean.setReportingEmpCode(request.getSession().getAttribute("empCode").
         * toString()); // beanCreator에서 셋팅하는데 또함..(dong) //실제 결제신청하는 사람 정보로 바꿔주는 소스임 이름
         * slipBean.setDeptCode(request.getSession().getAttribute("deptCode").toString()
         * ); //부서번호
         */
        if(slipStatus.equals("승인요청")) {
            slipEntity.setSlipStatus("승인요청"); //처음에 전표저장을 하면 null이라서 안 바꾸고 승인요청이 오면 바꾼다
        }

        ArrayList<JournalDto> journalEntities = new ArrayList<>();


        for (Object journalObjt : journalObjs) {
            JournalDto journalDto = gson.fromJson(journalObjt.toString(), JournalDto.class);
            System.out.println(slipEntity.getSlipNo()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            journalDto.setSlipNo(slipEntity.getSlipNo()); //slipNo을 journalBean에 값이 없어서 세팅해줌
            journalEntities.add(journalDto);

        }
        businessService.registerSlip(slipEntity, journalEntities);
    }

    @RequestMapping("/removeSlip")
    public void removeSlip(@RequestAttribute("reqData") PlatformData reqData,
                           @RequestAttribute("resData") PlatformData resData) throws Exception{
        String slipNo=reqData.getVariable("slipNo").getString();

        businessService.removeSlip(slipNo);

    }

    //@GetMapping("/approvalslip")
    @RequestMapping("/approveSlip")
    public void modifyapproveSlip(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception{
        ArrayList<SlipEntity> slipList = (ArrayList<SlipEntity>)datasetBeanMapper.datasetToBeans(reqData, SlipEntity.class);


//	            JSONArray approveSlipLists = JSONArray.fromObject(approveSlipList); // slip_no만 가지고옴 //JSONArray.fromObject json 객체로 만들어줌
//	            String slipStatus = isApprove; // true 승인버튼 누르면 true 가 넘어옴
//	            ArrayList<SlipEntity> slipEntities = new ArrayList<>(); //담는 값이 여러개
//
//	            for (Object approveSlip : approveSlipLists) { // 승인일자를 자바로 만든다
//	                Calendar calendar = Calendar.getInstance(); //import함
//	                String year = calendar.get(Calendar.YEAR) + "";
//	                String month = "0" + (calendar.get(Calendar.MONTH) + 1); // 0~11까지
//	                String date = "0" + calendar.get(Calendar.DATE);
//	                String today = year + "-" + month.substring(month.length() - 2) + "-" + date.substring(date.length() - 2); //인덱스 0,1 에서 0부터 시작하기 위해서 -2를 해주는듯 만약에 1자리인 경우에는 -1이니까 앞자리0부터???
//	                //2021-11-15
//	                System.out.println("approveSlip : " + approveSlip);
//	                SlipEntity slipEntity = new SlipEntity();
//	                slipEntity.setSlipNo(approveSlip.toString()); //전표번호
//	                slipEntity.setApprovalDate(today); //승인데이터 오늘날짜
//	                slipEntity.setSlipStatus(slipStatus); //전표상태
//	               // slipBean.setApprovalEmpCode(request.getSession().getAttribute("empCode").toString()); //String 형식 세션 값 읽기
//	                slipEntities.add(slipEntity);
//	            }

        businessService.modifyapproveSlip(slipList);

    }

    @RequestMapping("/findRangedSlipList")
    public void findRangedSlipList(@RequestAttribute("reqData") PlatformData reqData,
                                   @RequestAttribute("resData") PlatformData resData) throws Exception{

        String from = reqData.getVariable("startDate").getString();
        String to = reqData.getVariable("endDate").getString();
        String slipStatus = reqData.getVariable("slipStatus").getString();

        HashMap<String, Object> param = new HashMap<>();
        param.put("fromDate", from);
        param.put("toDate", to);
        param.put("slipStatus", slipStatus);
        ArrayList<SlipDto> slipList =  businessService.findRangedSlipList(param);
        datasetBeanMapper.beansToDataset(resData, slipList, SlipDto.class);

    }

    @GetMapping("/disapprovalsliplist")
    public ArrayList<SlipEntity> findDisApprovalSlipList() {

        return businessService.findDisApprovalSlipList();
    }
    @GetMapping("/findSlip")
    public ArrayList<SlipEntity> findSlip(@RequestParam String slipNo) {

        return businessService.findSlip(slipNo);
    }

    @GetMapping("/accountingsettlementstatus")
    public HashMap<String, Object> findAccountingSettlementStatus(@RequestParam String accountPeriodNo,
                                                                  @RequestParam String callResult) {
        JSONObject json = new JSONObject();
        HashMap<String, Object> params = new HashMap<>();

        params.put("accountPeriodNo", accountPeriodNo);
        params.put("callResult",callResult);

        json.put("errorCode", 0); json.put("errorMsg", "데이터 조회 성공");

        businessService.findAccountingSettlementStatus(params);


        return params;
    }

}
