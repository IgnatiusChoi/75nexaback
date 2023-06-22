package kr.co.seoulit.account.sys.base.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.sys.base.to.MenuEntity;

@Mapper
public interface MenuMapper {
    ArrayList<MenuEntity> selectMenuList(String empCode);

    ArrayList<MenuEntity> selectAllMenuList();
    
    ArrayList<MenuEntity> selectMenuNameList(String deptCode);

}
