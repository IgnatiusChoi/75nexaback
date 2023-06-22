package kr.co.seoulit.account.operate.humanresource.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_department")
public class DepartmentBean extends BaseBean{
	
	private String workplaceCode;
	private String workplaceName;
	private String deptCode;
	private String deptName;
	private String companyCode;
	private String deptStartDate;
	private String deptEndDate;
	
	
	

}
