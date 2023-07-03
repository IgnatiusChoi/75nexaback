package kr.co.seoulit.account.settlement.monthIncomeStatement.service;

import kr.co.seoulit.account.settlement.monthIncomeStatement.mapper.MonthIncomeStatementMapper;
import kr.co.seoulit.account.settlement.monthIncomeStatement.to.MonthIncomeStatementBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MonthIncomeStatementServiceImpl implements MonthIncomeStatementService{

    @Autowired
    private MonthIncomeStatementMapper monthIncomeStatementDAO;

    //월별손익계산서 조회
    @Override
    public ArrayList<MonthIncomeStatementBean> findMonthIncomeStatement(HashMap<String,Object> params) {
        //HashMap<String, String> map = new HashMap<String, String>();
        //map.put("date", date);
        System.out.println("월별손익계산서_ServiceImpl");
        System.out.println("selectedDate : " + params);
        //ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementDAO.selectMonthIncomeStatement(map);

        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = null;
        monthIncomeStatementList = monthIncomeStatementDAO.selectMonthIncomeStatement(params);

        //monthIncomeStatementDAO.selectMonthIncomeStatement(params);
        //return monthIncomeStatementList;
        System.out.println("params11 : " + params);
        //return null;
        return monthIncomeStatementList;
    }
}
