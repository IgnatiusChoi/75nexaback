package kr.co.seoulit.account.settlement.monthIncomeStatement.service;

import kr.co.seoulit.account.settlement.monthIncomeStatement.mapper.MonthIncomeStatementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonthIncomeStatementServiceImpl implements MonthIncomeStatementService{

    @Autowired
    private MonthIncomeStatementMapper monthIncomeStatementDAO;

    //월별손익계산서 조회
//    @Override
//    public ArrayList<MonthIncomeStatementBean> findMonthIncomeStatement(String fromDate, String toDate) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("fromDate", fromDate);
//        map.put("toDate", toDate);
//        ArrayList<MonthIncomeStatementBean> monthIncomeStatementList = monthIncomeStatementDAO.selectMonthIncomeStatement(map);
//
//        return monthIncomeStatementList;
//    }
}
