package kr.co.seoulit.account.settlement.costStatement.service;

import kr.co.seoulit.account.settlement.costStatement.mapper.CostStatementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostStatementServiceImpl implements CostStatementService{

    @Autowired
    private CostStatementMapper costStatementDAO;

//    @Override
//    public ArrayList<CostStatementBean> findCostStatement(String date) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("date", date);
//        ArrayList<CostStatementBean> costStatementList = costStatementDAO.selectCostStatement(map);
//
//        return costStatementList;
//    }
}
