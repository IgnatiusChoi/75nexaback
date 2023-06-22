package kr.co.seoulit.account.operate.system.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_bbs")
public class BoardBean extends BaseBean {

	private int bbsID;
	private String bbsTitle;
	private String bbsContents;
	private String bbsDate;
	private String empName;
	private String checked;
}
