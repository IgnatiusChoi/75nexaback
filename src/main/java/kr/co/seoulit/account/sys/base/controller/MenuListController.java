package kr.co.seoulit.account.sys.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.sys.base.service.BaseService;
import kr.co.seoulit.account.sys.base.service.BaseServiceImpl;
import kr.co.seoulit.account.sys.base.to.MenuEntity;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/base")
public class MenuListController {  // 하나의 컨트롤러에서 여러개의 요청처리 지원

    @Autowired
    private BaseService baseService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("/findMenuList")
    public ArrayList<MenuEntity>findMenuList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
    	
    	ArrayList<MenuEntity> menuList = baseService.selectAllMenuList();

        datasetBeanMapper.beansToDataset(resData, menuList, MenuEntity.class);
        return null;
    }
    
	//@GetMapping("/findUserMenuList")
    public ArrayList<MenuEntity> findUserMenuList(@RequestParam String deptCode) {
           
            ArrayList<MenuEntity> menuList = baseService.findUserMenuList(deptCode);   // 2) 그 empCode에 대해 메뉴리스트 뽑아옴
        
        return menuList;


    }



}
