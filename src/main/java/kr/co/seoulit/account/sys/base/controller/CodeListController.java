package kr.co.seoulit.account.sys.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.service.BaseServiceImpl;
import kr.co.seoulit.account.sys.base.to.CodeBean;
import kr.co.seoulit.account.sys.base.to.CustomerEntity;
import kr.co.seoulit.account.sys.base.to.DetailCodeEntity;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/base")
public class CodeListController {
	private BaseService baseService;
	private DatasetBeanMapper datasetBeanMapper;

	@Autowired
	public CodeListController(BaseService baseService, DatasetBeanMapper datasetBeanMapper) {
		this.baseService = baseService;
		this.datasetBeanMapper = datasetBeanMapper;

	}

	@GetMapping("/detailcodelist")
	public ArrayList<DetailCodeEntity> findDetailCodeList(@RequestParam String divisionCodeNo,
			@RequestParam(value = "detailCodeName", required = false) String detailCodeName) {

		HashMap<String, String> param = new HashMap<>();

		param.put("divisionCodeNo", divisionCodeNo);
		if (detailCodeName != null) // detailCodeName 입력 시
			param.put("detailCodeName", detailCodeName); // param에 값 담음

		ArrayList<DetailCodeEntity> detailCodeList = baseService.findDetailCodeList(param);

		return detailCodeList;

	}

	@RequestMapping("codeList")
	public ArrayList<DetailCodeEntity> findDetailCodeList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {
		ArrayList<DetailCodeEntity> detailCodeList = baseService.findCodeDetailList();
		datasetBeanMapper.beansToDataset(resData, detailCodeList, DetailCodeEntity.class);
		return null;
	}

	//@GetMapping("/codelist")
	public ArrayList<CodeBean> findCodeList() {

		ArrayList<CodeBean> codeList = baseService.findCodeList();

		return codeList;
	}

	@GetMapping("/batchCodeProcess")
 public void batchCodeProcess(@RequestParam String batchList,@RequestParam String batchList2) {

         ObjectMapper mapper = new ObjectMapper();
         try {
         ArrayList<CodeBean> codeList = mapper.readValue(batchList, new TypeReference<ArrayList<CodeBean>>() {
         });

         ArrayList<DetailCodeEntity> codeList2;
			
				
					codeList2 = mapper.readValue(batchList2,
					        new TypeReference<ArrayList<DetailCodeEntity>>() {
					        });
					baseService.batchCodeProcess(codeList, codeList2);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
				 
         /* nexacro */
         @RequestMapping("findCustomerCodeList")
         public void findcustomerCodeList(@RequestAttribute("reqData") PlatformData reqData,
                                          @RequestAttribute("resData") PlatformData resData) throws Exception {
             System.out.println("어디서 에러가 나니...? CustomerCodeList시작.");
             ArrayList<CustomerEntity> resultList =  baseService.findCustomerList();

             datasetBeanMapper.beansToDataset(resData, resultList, CustomerEntity.class);
         }
 


}
