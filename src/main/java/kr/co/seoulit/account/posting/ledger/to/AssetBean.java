package kr.co.seoulit.account.posting.ledger.to;

import kr.co.seoulit.account.sys.common.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name = "ds_asset")
public class AssetBean {
	private int assetNumber;
	private String assetName, assetCode;
	
}