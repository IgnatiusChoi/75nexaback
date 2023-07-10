package kr.co.seoulit.account.settlement.trialbalance.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import kr.co.seoulit.account.settlement.trialbalance.to.EarlyAssetBean;

@Mapper
public interface TotalTrialBalanceMapper {

    public HashMap<String, Object> selectcallTotalTrialBalance(HashMap<String,Object> params);

    public HashMap<String, Object> selectcallEarlyStatements(HashMap<String,Object> params);

    //일(월)계표 조회
    List<DetailTrialBalanceBean> selectDetailTrialBalance(HashMap<String, Object> params);

	public HashMap<String, Object> selectAccountingSettlement(HashMap<String, String> map);
}
