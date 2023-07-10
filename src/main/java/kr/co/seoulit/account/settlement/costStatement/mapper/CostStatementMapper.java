package kr.co.seoulit.account.settlement.costStatement.mapper;

import kr.co.seoulit.account.settlement.costStatement.to.CostStatementBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface CostStatementMapper {

    //원가명세서 조회
    //public ArrayList<CostStatementBean> selectCostStatement(HashMap<String,Object> params);
    public HashMap<String, Object> selectCostStatement(HashMap<String,Object> params);

}
