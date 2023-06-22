package kr.co.seoulit.account.posting.ledger.to;

import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name = "ds_assetitem")
public class AssetItemBean {
	String assetItemCode;
	String assetItemName;
	String acquisitionDate; //취득일자
	int acquisitionAmount; //취득금액
	int usefulLift; //내용연수
	String manageMentDeptName; // 관리부서이름
	String parentsCode;
	String parentsName;
	String accumulatedDepreciation; // 감가상각누계액
	String residualValue; // 잔존가치
	String status;
	
}
