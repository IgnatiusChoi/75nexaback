package kr.co.seoulit.account.operate.system.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobesoft.xplatform.data.PlatformData;

import kr.co.seoulit.account.operate.system.service.SystemService;
import kr.co.seoulit.account.operate.system.to.BoardBean;
import kr.co.seoulit.account.operate.system.to.WorkplaceEntity;
import kr.co.seoulit.account.sys.common.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/operate")
public class BoardController {

		@Autowired
		private SystemService systemService;
		@Autowired
		private DatasetBeanMapper datasetBeanMapper;
		
		@RequestMapping("/insertBoard")
		public void insertBoard(@RequestAttribute("reqData")PlatformData reqData,
	            @RequestAttribute("resData")PlatformData resData) throws Exception {
			BoardBean bean = datasetBeanMapper.datasetToBean(reqData, BoardBean.class);
			systemService.insertBoard(bean);
		}
		@RequestMapping("/updateBoard")
		public void updateBoard(@RequestAttribute("reqData")PlatformData reqData,
				@RequestAttribute("resData")PlatformData resData) throws Exception {
			BoardBean bean = datasetBeanMapper.datasetToBean(reqData, BoardBean.class);
			systemService.updateBoard(bean);
		}
		
		@RequestMapping("/selectBoard")
		public ArrayList<BoardBean> selectBoard(@RequestAttribute("reqData")PlatformData reqData,
				@RequestAttribute("resData")PlatformData resData) throws Exception {
			ArrayList<BoardBean> boradList = systemService.selectBoardList();
	        datasetBeanMapper.beansToDataset(resData, boradList, BoardBean.class);
			return null;
			}
	        
	        @RequestMapping("/selectBoarddetail")
	        public ArrayList<BoardBean> selectBoarddetail(@RequestAttribute("reqData")PlatformData reqData,
	        		@RequestAttribute("resData")PlatformData resData) throws Exception {
	        	String row = reqData.getVariable("row").getString();
	        	ArrayList<BoardBean> boradList = systemService.selectBoarddetail(row);
	        	datasetBeanMapper.beansToDataset(resData, boradList, BoardBean.class);
			
			return null;
		}

	@RequestMapping("/removeBoard")
	public void removeBoard(@RequestAttribute("reqData")PlatformData reqData,
							@RequestAttribute("resData")PlatformData resData) throws Exception {
		//String bbsid = reqData.getVariable("bbsid").getString();
		systemService.removeBoard();

	}
		
		
}
