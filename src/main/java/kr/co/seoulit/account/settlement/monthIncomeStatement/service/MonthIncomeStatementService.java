package kr.co.seoulit.account.settlement.monthIncomeStatement.service;

import kr.co.seoulit.account.settlement.monthIncomeStatement.to.MonthIncomeStatementBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface MonthIncomeStatementService {

    //월별손익계산서 조회
    ArrayList<MonthIncomeStatementBean>  findMonthIncomeStatement(HashMap<String,Object> params);
}
