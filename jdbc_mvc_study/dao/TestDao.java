package com.kh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dto.TestDto;

import static com.kh.db.JDBCTemplate.*;

//dao (data access object) : db와 연결하는 코드만 작성
//DB 와 연결을 통해 Select / Insert / Update / Delete 작업을 수행하는 Class(5단계)
public class TestDao {


 //전체출력 
	public List<TestDto> selectList() {
		// 1.
		// 2.계정연결
		//(1,2)는 JDBCTemplate을 이용해서 따로 빼주었다.
		Connection con = getConnection();
		// 3.
		String sql = " SELECT NO, NAME, PHONE, ADDR " + " FROM KHTEST " + " ORDER BY NO DESC ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		 //selectlist 는 테이블이 리턴되기 때문에 , ResultSet으로 db의 테이블을 담아줄 객체 생성
		List<TestDto> list = new ArrayList<TestDto>();
		//ArrayList<> arrayList = new ArrayList<>();
	    //ArrayList: 배열은 지정한 크기 이상의 데이터 넣으려고 하면 오류가 나기 때문에 이를 대체하기 위한 방법으로 arrylist라는 클래스를 사용한다.
		try {
			pstm = con.prepareStatement(sql);
			//(sql)의 맵핑방식에 따라 prepareStatement와 statement(하나하나문자열로 지정해 줘야해서 ''를 붙여주기 귀찮아서 )를 사용가능한데 ,prepareStatement가 편해서 주로 씀.

			// 4. 쿼리 실행 및 리턴
			rs = pstm.executeQuery();
			//select문은 executeQuery 사용 =>return 을 보냄.
	        //1. executeQuery로 가져온 것을 rs(ResultSet)에 담아서,
			while (rs.next()) {
				TestDto dto = new TestDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddr(rs.getString(4));
			//2.ResultSet에 있는 한줄한줄의 컬럼들 값을 가지고 와서. dto에 담음.


				list.add(dto);
				//dto들을 담아서 리스트에 담음 (1번)
				//dto들을 담아서 리스트에 담음 (2번)
				//dto들을 담아서 리스트에 담음 (3번)...이렇게 한줄 한줄 담아서 그 줄들을 list로 관리
				//-list:여러개의 값들을 효과적으로 관리하는 컬렉션
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.쿼리종료
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}



  //선택출력
	public TestDto selectOne(int no) {
		// 1.
		// 2.
		Connection con = getConnection();
		// 3.
		String sql = " SELECT NO, NAME, PHONE, ADDR " + " FROM KHTEST " + " WHERE NO = " + no;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TestDto dto = new TestDto(); // <- 얘 밖으로 안빼주면 return dto;부분에러남

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddr(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return dto;
	}



   //추가
		public int insert(TestDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();

		// 3.
		String sql = " INSERT INTO KHTEST " + " VALUES(?, ?, ?, ?) ";
		PreparedStatement pstm = null;
		int res = 0;
		//insert,update,delete는 숫자로 row갯수가 반환되기 때문에 int res = 0;을 써준다. ResultSet이 아니라
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getPhone());
			pstm.setString(4, dto.getAddr());

			// 4.
			res = pstm.executeUpdate();
			//insert,update,delete 는 executeUpdate사용 =>return을 보내지 않음

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}

		return res;
	}

	// 수정
	public int update(TestDto dto) {
		// 1.
		// 2.
		Connection con = getConnection();
		// 3.

		String sql = " UPDATE KHTEST " + " SET NAME = ?, PHONE = ? , ADDR =? " + " WHERE NO = ? ";

		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getPhone());
			pstm.setString(4, dto.getAddr());
			// 4.
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		return res;
	}

	// 삭제
	public int delete(int no) {
		// 1.
		// 2.
		Connection con = getConnection();
		// 3.
		String sql = " DELETE FROM KHTEST WHERE NO = ?";

		PreparedStatement pstm = null;
		int res = 0;
		try {

			// 4.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.
			close(pstm);
			close(con);
		}
		return res;
	}

}
