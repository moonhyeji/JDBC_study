package com.kh.biz;

import java.util.List;

import com.kh.dao.TestDao;
import com.kh.dto.TestDto;

public class TestBiz {

	TestDao dao = new TestDao();

	public List<TestDto> selectList(){
		return dao.selectList();
	}

	public TestDto selectOne(int no) {
		return dao.selectOne(no);
	}


	public int insert(TestDto dto) {
		return dao.insert(dto);

	}

	public int update(TestDto dto) {
		return dao.update(dto);
	}

	public int delete(int no) {
		return dao.delete(no);
	}

}
