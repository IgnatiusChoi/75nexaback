package kr.co.seoulit.account.operate.system.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.AuthorityEmpBean;
import kr.co.seoulit.account.operate.system.to.AuthorityMenuEntity;

@Mapper
public interface AuthorityGroupMapper {

    public ArrayList<AuthorityEmpBean> selectAuthorityEmp(String deptCode);
    
    public void updateAuthorityGroup(AuthorityEmpBean authorityEmpBean, String dept);
    
    public void insertAuthorityGroup(String addAuthority,String nextGroupCode);
    
    public ArrayList<AuthorityEmpBean> selectAuthorityGroupCode();
    
    public ArrayList<AuthorityMenuEntity> selectEmpAuthorityMenu(String empCode);
    
    public void deleteAuthorityGroup(String groupCode);
    
    public void deleteAuthorityMenu(String groupCode);
    
    public ArrayList<AuthorityMenuEntity> selectAuthorityGroup();
    
    public ArrayList<AuthorityMenuEntity> selectAuthorityMenu(HashMap<String, String> map);
    
    public void updateAuthorityMenu(AuthorityMenuEntity authorityMenuEntity, String dept);
}
