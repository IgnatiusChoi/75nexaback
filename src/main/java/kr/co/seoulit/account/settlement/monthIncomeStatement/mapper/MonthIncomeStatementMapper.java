package kr.co.seoulit.account.settlement.monthIncomeStatement.mapper;

import kr.co.seoulit.account.settlement.monthIncomeStatement.to.MonthIncomeStatementBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MonthIncomeStatementMapper {

    //월별손익계산서 조회
    public HashMap<String, Object>  selectMonthIncomeStatement(HashMap<String,Object> params);
}
