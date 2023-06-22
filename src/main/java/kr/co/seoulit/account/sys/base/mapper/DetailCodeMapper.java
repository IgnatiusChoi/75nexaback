package kr.co.seoulit.account.sys.base.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.sys.base.to.DetailCodeEntity;

@Mapper
public interface DetailCodeMapper {

    ArrayList<DetailCodeEntity> selectDetailCodeList(HashMap<String, String> param);

    void insertDetailCode(DetailCodeEntity codeDetailBean);

    void updateDetailCode(DetailCodeEntity codeDetailBean);

    void deleteDetailCode(String codeNo);

}
