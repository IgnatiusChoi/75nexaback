package kr.co.seoulit.account.posting.ledger.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.posting.ledger.mapper.CustomerLedgerMapper;
import kr.co.seoulit.account.posting.ledger.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;
import kr.co.seoulit.account.posting.ledger.mapper.AssistantLedgerMapper;
import kr.co.seoulit.account.posting.ledger.mapper.AuxiliaryLedgerMapper;
import kr.co.seoulit.account.posting.ledger.mapper.JournalEntryMapper;

@Service
@Transactional
public class LedgerServiceImpl implements LedgerService {
    
	@Autowired
    private JournalEntryMapper journalEntryDAO;
	@Autowired
    private AuxiliaryLedgerMapper auxiliaryLedgerDAO;
	@Autowired
    private AssistantLedgerMapper assistantLedgerDAO;
	@Autowired
	private CustomerLedgerMapper customerLedgerDAO;

    
    @Override
	public ArrayList<CashJournalBean> findTotalCashJournal(HashMap<String, String> map) {

        	ArrayList<CashJournalBean> cashJournalList = auxiliaryLedgerDAO.selectTotalCashJournalList(map);

        return cashJournalList;
	}
	
	@Override
	public ArrayList<CashJournalBean> findCashJournal(String fromDate, String toDate, String account) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
			map.put("account", account);
        	// cashJournalList = null;
        	 ArrayList<CashJournalBean> cashJournalList = auxiliaryLedgerDAO.selectCashJournalList(map);

        return cashJournalList;
	}
	
	@Override
    public ArrayList<JournalEntity> findRangedJournalList(String fromDate, String toDate) {

        	ArrayList<JournalEntity> journalList = null;
        	journalList = journalEntryDAO.selectRangedJournalList(fromDate, toDate);
        	
        return journalList;
    }
	
	@Override
    public ArrayList<JournalDetailEntity> findJournalDetailList(String journalNo) {

        	ArrayList<JournalDetailEntity> journalDetailEntities = null;
        	journalDetailEntities = journalEntryDAO.selectJournalDetailList(journalNo);

        return journalDetailEntities;
    }
	
	@Override
	public ArrayList<AssetBean> findAssetList() {
		

        	ArrayList<AssetBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetList();

        return assetBean;
	}
	
	@Override
	public ArrayList<AssetItemBean> findAssetItemList(String assetCode) {
		
        	ArrayList<AssetItemBean> assetBean = null;
        	assetBean = assistantLedgerDAO.selectAssetItemList(assetCode);

        return assetBean;
	}
	
	@Override
	public ArrayList<DeptBean> findDeptList(){

        	ArrayList<DeptBean> DeptBean = null;
        	DeptBean = assistantLedgerDAO.selectDeptList();

        return DeptBean;
	}
	
	@Override
	public void assetStorage(HashMap<String, Object> map) {
			
			if(map.get("previousAssetItemCode").equals("CREATE")) {
				assistantLedgerDAO.createAssetItem(map);
			}
			else {
				assistantLedgerDAO.updateAssetItem(map);
			}
          
	}
	
	public void Insertasset(AssetItemBean bean) {
		
			assistantLedgerDAO.insertAssetItem(bean);
		
	}
	
	@Override
	public void removeAssetItem(String assetItemCode) {

			assistantLedgerDAO.removeAssetItem(assetItemCode);
           
	}

	@Override
	public ArrayList<CustomerLedgerBean> findCustomerLedger(String fromDate, String toDate){

		ArrayList<CustomerLedgerBean> customerLedgerBean = customerLedgerDAO.selectCustomerLedgerList(fromDate,toDate);
			return customerLedgerBean;
	}
	@Override
	public ArrayList<CustomerLedgerDetailBean> findCustomerLedgerDetailList(String customerCode){
		ArrayList<CustomerLedgerDetailBean> customerLedgerDetailBean = customerLedgerDAO.selectCustomerLedgerDetailList(customerCode);
		return customerLedgerDetailBean;
	}
}
