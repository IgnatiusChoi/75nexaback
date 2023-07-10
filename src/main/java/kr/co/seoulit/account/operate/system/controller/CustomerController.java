package kr.co.seoulit.account.operate.system.controller;

import com.tobesoft.xplatform.data.PlatformData;
import kr.co.seoulit.account.operate.system.entity.Customer;
import kr.co.seoulit.account.operate.system.service.CustomerService;
import kr.co.seoulit.account.operate.system.to.CustomerUpdateRequest;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/operate")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    ModelAndView mav;
    ModelMap map = new ModelMap();

//	// 업태리스트조회
//	@GetMapping("/businesslist")
//	public ArrayList<BusinessBean> findBusinessList() {
//
//			ArrayList<BusinessBean>	businessList = systemService.findBusinessList();
//
//		return businessList;
//
//	}
//
//	@GetMapping("/detailbusiness")
//	public ArrayList<DetailBusinessBean> findDetailBusiness(@RequestParam String businessCode) {
//
//			ArrayList<DetailBusinessBean> detailBusinessList = systemService.findDetailBusiness(businessCode);
//
//	            return detailBusinessList;
//
//
//	}

    @RequestMapping("/registerCustomer")
    public void registerCustomer(@RequestAttribute("reqData")PlatformData reqData,
                                 @RequestAttribute("resData")PlatformData resData) throws Exception {
        System.out.println("reqData = " + reqData.toString());
//		CustomerUpdateRequest customerUpdateRequest = datasetBeanMapper.datasetToBean(reqData, CustomerUpdateRequest.class);
        List<CustomerUpdateRequest> customerUpdateRequests = datasetBeanMapper.datasetToBeans(reqData, CustomerUpdateRequest.class);
        customerService.registerCustomers(customerUpdateRequests);
    }

//	@RequestMapping("/removeWorkplace")
//    public void removeWorkplace(@RequestAttribute("reqData")PlatformData reqData,
//            @RequestAttribute("resData")PlatformData resData) throws Exception {
//
//        String workplaceCode = reqData.getVariable("workplaceCode").getString();
//
//
//			systemService.removeWorkplace(workplaceCode); //delete
//
// }
//    @PostMapping("/workplace")
//	public WorkplaceEntity findWorkplace(@RequestParam String workplaceCode) {
//
//     WorkplaceEntity  workplaceEntity = new WorkplaceEntity();
//
//     workplaceEntity = systemService.findWorkplace(workplaceCode);
//
//     return workplaceEntity;
// }

    @RequestMapping("/customerList")
    public void findAllCustomerList(@RequestAttribute("reqData")PlatformData reqData,
                                    @RequestAttribute("resData")PlatformData resData) throws Exception {
        System.out.println("@@@@customerList@@@@");
        List<Customer> customerList = customerService.findCustomerList();
        System.out.println("customerList = " + customerList);
        datasetBeanMapper.beansToDataset(resData, customerList, Customer.class);
    }
//
//	@GetMapping("/approvalstatusmodification")
//	public void modifyApprovalStatus(@RequestParam String status,
//											 @RequestParam String codes	) {
//
//		ArrayList<String> getCodes=new ArrayList<>();
//
//			JSONArray jsonArray=JSONArray.fromObject(codes);
//			for(Object obj :jsonArray) {
//				String code=(String)obj;
//				getCodes.add(code);
//			}
//
//			systemService.modifyApprovalStatus(getCodes,status);
//
//	}

}
