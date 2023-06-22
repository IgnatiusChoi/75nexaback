package kr.co.seoulit.account.sys.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tobesoft.xplatform.data.PlatformData;
import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeEntity;
import kr.co.seoulit.account.operate.system.service.SystemService;
import kr.co.seoulit.account.operate.system.to.PeriodEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/base")
public class MemberLoginController {

	@Autowired
	private BaseService baseService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;


	@RequestMapping("/login")
	public ModelAndView handleRequestInternal( @RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {

		String empCode = reqData.getVariable("empCode").getString();
		String userPw = reqData.getVariable("userPw").getString();
		String today = reqData.getVariable("today").getString();
		System.out.println("view 에서 넘겨 받은 값 : empCode = " + empCode + ", userPw = " + userPw + ", today = " + today);
		EmployeeEntity employeeEntity = baseService.findLoginData(empCode, userPw);
		System.out.println(employeeEntity.getEmpCode());
		System.out.println("      @ BaseService에서 접근 권한을 얻어옴");
		String periodNo = baseService.findPeriodNo(today); // 회계기수를 반환함. 오늘날짜가 period기수정보 테이블에 없으면 null
		System.out.println("today: " + today);
		System.out.println("      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: " + periodNo);

		System.out.println("여기");
		System.out.println(today);
		if (periodNo == null) {
			String[] str = today.split("-"); // str={"2020","02","05"}
			System.out.println(str);
			String sdate = str[0] + "-" + "01-01";
			System.out.println(sdate);
			String edate = str[0] + "-" + "12-31";
			System.out.println(edate);
			baseService.registerPeriodNo(sdate, edate); // sdate=2020-01-01 sdate=2020-12-31
			periodNo = baseService.findPeriodNo(today);
			baseService.modifyEarlyStatements(periodNo);
			// baseService.setEarlyStatements(periodNo); 사용안함
		}
		ArrayList<PeriodEntity> periodNoList = systemService.findAccountPeriodList();

		datasetBeanMapper.beanToDataset(resData, employeeEntity, EmployeeEntity.class);
		datasetBeanMapper.beansToDataset(resData, periodNoList, PeriodEntity.class);

		return null;
	}

}