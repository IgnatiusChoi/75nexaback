package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.SlipEntity;

@Mapper
public interface SlipApprovalAndReturnMapper {
	
    void updateapproveSlip(SlipEntity slipEntity);
    
    public ArrayList<SlipEntity> selectDisApprovalSlipList();
}
