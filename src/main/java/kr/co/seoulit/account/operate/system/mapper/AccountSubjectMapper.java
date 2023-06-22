package kr.co.seoulit.account.operate.system.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.AccountEntity;
import kr.co.seoulit.account.operate.system.to.AccountControlEntity;
import kr.co.seoulit.account.operate.system.to.PeriodEntity;

@Mapper
public interface AccountSubjectMapper {

    public AccountEntity selectAccount(String accountCode);

    public ArrayList<AccountEntity> selectDetailAccountList(String code);

    public ArrayList<AccountEntity> selectParentAccountList();

    public void updateAccount(AccountEntity accountEntity);

    public ArrayList<AccountEntity> selectAccountListByName(String accountName);

    public ArrayList<AccountControlEntity> selectAccountControlList(String accountCode);
    
    public ArrayList<AccountEntity> selectDetailBudgetList(String code);
    
    public ArrayList<AccountEntity> selectParentBudgetList();
    
    public ArrayList<PeriodEntity> selectAccountPeriodList();
    
    public ArrayList<PeriodEntity> selectPeriodList();

    public ArrayList<AccountEntity> selectAccountList();
}
