package kr.co.seoulit.account.operate.system.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.operate.system.to.BoardBean;

@Mapper
public interface BoardMapper {

		public void insertBoard(BoardBean bean) ;
		
		public void updateBoard(BoardBean bean) ;
		
		public ArrayList<BoardBean> selectBoardList();
		
		public ArrayList<BoardBean> selectBoarddetail(String row);

		public void deleteBoard();
}
