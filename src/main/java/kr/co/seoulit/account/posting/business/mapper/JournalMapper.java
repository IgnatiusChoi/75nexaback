package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;

@Mapper
public interface JournalMapper {

    public ArrayList<JournalEntity> selectJournalList(String slipNo);

    public void deleteJournal(String journalNo);
    
    public void deleteJournalAll(String slipNo);

    public boolean updateJournal(JournalEntity journalEntity);
    
    ArrayList<JournalDetailEntity> selectJournalDetailList(String journalNo);
    
    ArrayList<JournalDetailEntity> detailAccountList(String accountCode);
    
    String selectJournalDetailDescriptionName(String journalDetailNo);

    public void deleteJournalDetail(String journalNo);
    
    public void deleteJournalDetailByJournalNo(String journalNo);

    public void updateJournalDetail(JournalDetailEntity journalDetailEntity);

    public void insertJournalDetailList(JournalDetailEntity journalDetailEntity);

	public ArrayList<JournalEntity> selectRangedJournalList(HashMap<String, String> map);

	public void insertJournal(JournalEntity journalEntity);

	public String selectJournalName(String slipNo);
}
