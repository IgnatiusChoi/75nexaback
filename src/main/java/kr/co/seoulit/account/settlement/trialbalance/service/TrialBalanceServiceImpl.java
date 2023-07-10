package kr.co.seoulit.account.settlement.trialbalance.service;

import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.account.settlement.trialbalance.to.DetailTrialBalanceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.settlement.trialbalance.mapper.TotalTrialBalanceMapper;

@Service
@Transactional
public class TrialBalanceServiceImpl implements TrialBalanceService{

	@Autowired
    private TotalTrialBalanceMapper totalTrialBalanceDAO;

    @Override
    public HashMap<String, Object> findTotalTrialBalance(HashMap<String,Object> params) {

        	HashMap<String, Object> trialBalanceList = null;
        	trialBalanceList = totalTrialBalanceDAO.selectcallTotalTrialBalance(params);

        return trialBalanceList;
    }

    @Override
	public HashMap<String, Object> findEarlyStatements(HashMap<String,Object> params) {

    		 HashMap<String, Object> earlyledgersList = null;
	    	 earlyledgersList = totalTrialBalanceDAO.selectcallEarlyStatements(params);

	     return earlyledgersList;
	 }

    @Override
	public HashMap<String, Object> findchangeAccountingSettlement(String accountPeriodNo, String callResult) {

        	HashMap<String, String> map = new HashMap<>();
        	map.put("accountPeriodNo", accountPeriodNo);
        	map.put("callResult", callResult);
        	return totalTrialBalanceDAO.selectAccountingSettlement(map);
    }

	//일(월)계표 조회
    @Override
//	public HashMap<String, Object> findDetailTrialBalance(HashMap<String, Object> params) {
//
//		HashMap<String, Object> detailTrialBalance = null;
//		detailTrialBalance = totalTrialBalanceDAO.selectDetailTrialBalance(params);
//	        return detailTrialBalance;
//
//    }
	public List<DetailTrialBalanceBean> findDetailTrialBalance(HashMap<String, Object> params) {

		List<DetailTrialBalanceBean> detailTrialBalance = null;
		detailTrialBalance = totalTrialBalanceDAO.selectDetailTrialBalance(params);
		return detailTrialBalance;

	}
}
