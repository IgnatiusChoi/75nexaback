package kr.co.seoulit.account.settlement.trialbalance.service;

import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;

import java.util.HashMap;
import java.util.List;

public interface TrialBalanceService {

	 public HashMap<String, Object> findTotalTrialBalance(HashMap<String, Object> params);

	 public HashMap<String, Object> findEarlyStatements(HashMap<String, Object> params);

	 public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult);

	//일(월)계표 조회
	 public List<DetailTrialBalanceBean> findDetailTrialBalance(HashMap<String, Object> params);

}
