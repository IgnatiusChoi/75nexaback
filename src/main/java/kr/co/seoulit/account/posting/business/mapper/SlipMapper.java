package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.SlipEntity;

@Mapper
public interface SlipMapper {

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipEntity slipEntity);

    public void insertSlip(SlipEntity slipEntity);

    public ArrayList<SlipEntity> selectRangedSlipList(HashMap<String, Object> param);

    public int selectSlipCount(String today);
    
    public ArrayList<SlipEntity> selectSlipDataList(String slipDate);
	
    public ArrayList<SlipEntity> selectSlip(String slipNo);
        
    public HashMap<String, Object> selectAccountingSettlementStatus(HashMap<String, Object> param);
}
