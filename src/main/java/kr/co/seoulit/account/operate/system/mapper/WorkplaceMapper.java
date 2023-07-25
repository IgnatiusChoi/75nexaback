package kr.co.seoulit.account.operate.system.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.BusinessBean;
import kr.co.seoulit.account.operate.system.to.DetailBusinessBean;
import kr.co.seoulit.account.operate.system.to.WorkplaceEntity;

@Mapper
public interface WorkplaceMapper {

    public ArrayList<BusinessBean> selectBusinessList();

    public void updateWorkplaceAccount(String code,String status); //사업장 승인상태 업데이트

    public WorkplaceEntity selectWorkplace(String workplaceCode); //사업장조회

	public void insertWorkplace(WorkplaceEntity workplaceEntity); //사업장추가

	public void deleteWorkplace(String code); //사업장삭제

	public ArrayList<WorkplaceEntity> selectAllWorkplaceList(); //모든사업장조회
	
	public ArrayList<DetailBusinessBean> selectDetailBusinessList(String businessCode);
}
