package kr.co.seoulit.account.posting.ledger.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;
import kr.co.seoulit.account.posting.ledger.to.*;

public interface LedgerService {

    //현금출납장 조회
	ArrayList<CashJournalBean> findCashJournal(String fromDate, String toDate, String account);

    ArrayList<CashJournalBean> findTotalCashJournal(HashMap<String, String> map);

    ArrayList<JournalEntity> findRangedJournalList(String fromDate, String toDate);

    ArrayList<JournalDetailEntity> findJournalDetailList(String journalNo);

    ArrayList<AssetBean> findAssetList();

    ArrayList<AssetItemBean> findAssetItemList(String assetCode);

    ArrayList<DeptBean> findDeptList();

    void assetStorage(HashMap<String, Object> map);

    void removeAssetItem(String assetItemCode);

    public void Insertasset(AssetItemBean bean);

    ArrayList<CustomerLedgerBean> findCustomerLedger(String fromDate, String toDate);

    ArrayList<CustomerLedgerDetailBean> findCustomerLedgerDetailList(String customerCode);


}

