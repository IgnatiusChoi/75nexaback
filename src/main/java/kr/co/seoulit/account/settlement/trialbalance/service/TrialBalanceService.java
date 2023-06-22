package kr.co.seoulit.account.settlement.trialbalance.service;

import java.util.HashMap;

public interface TrialBalanceService {

	 public HashMap<String, Object> findTotalTrialBalance(HashMap<String, Object> params);
	 
	 public HashMap<String, Object> findEarlyStatements(HashMap<String, Object> params);
	 
	 public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult);
	 
	 public HashMap<String, Object> findDetailTrialBalance(HashMap<String, Object> params);
	 
}
