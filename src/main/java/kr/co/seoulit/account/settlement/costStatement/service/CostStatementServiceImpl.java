package kr.co.seoulit.account.settlement.costStatement.service;

import kr.co.seoulit.account.settlement.costStatement.mapper.CostStatementMapper;
import kr.co.seoulit.account.settlement.costStatement.to.CostStatementBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CostStatementServiceImpl implements CostStatementService{

    @Autowired
    private CostStatementMapper costStatementDAO;

    //원가명세서 조회
//    @Override
//    public ArrayList<CostStatementBean> findCostStatement(HashMap<String,Object> params) {
//
//        System.out.println("원가명세서_ServiceImpl");
//        System.out.println("selectedDate : " + params);
//
//        costStatementDAO.selectCostStatement(params);
//        System.out.println("params1 : " + params);
//        return null;
//    }

    @Override
    public ArrayList<CostStatementBean> findCostStatement(HashMap<String,Object> params) {

        System.out.println("원가명세서_ServiceImpl");
        System.out.println("selectedDate : " + params);

        HashMap<String, Object> map = costStatementDAO.selectCostStatement(params);
        ArrayList<CostStatementBean> result = (ArrayList<CostStatementBean>)params.get("RESULT");

        System.out.println("result : " + result);
        System.out.println("params1 : " + params);

        return result;
    }
}
