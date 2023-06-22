package kr.co.seoulit.account.posting.ledger.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.JournalEntity;
import kr.co.seoulit.account.posting.business.to.JournalDetailEntity;

@Mapper
public interface JournalEntryMapper {
	
    public ArrayList<JournalEntity> selectRangedJournalList(String fromDate, String toDate);
    
    ArrayList<JournalDetailEntity> selectJournalDetailList(String journalNo);
}
