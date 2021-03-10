package com.kh.controller;

import java.util.List;
import java.util.Scanner;

import com.kh.biz.TestBiz;
import com.kh.dto.TestDto;

public class TestController {

	private static Scanner sc = new Scanner(System.in);

	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;

		sb.append("1.전체출력\n")
		  .append("2.선택출력\n")
		  .append("3.추가\n")
		  .append("4.수정\n")
		  .append("5.삭제\n")
		  .append("6.종료\n")
		  .append("번호선택 : \n");
		System.out.println(sb);
		select = sc.nextInt();
		return select;
	}

	public static void main(String[] args) {

		int select = 0;
		TestBiz biz = new TestBiz();
//controller->biz호출 ->dao호출 ->db호출해서 값 가져옴 ->dao에 리턴 ->biz리턴 ->controller에 리턴 . 따라서 biz가 필요함.


		while (select != 6) {
			select = getMenu();
			switch(select) {


			case 1:
				System.out.println("전체 출력");
				List<TestDto> list = biz.selectList();
				for (TestDto dto : list) {
					System.out.println(dto);
				}
				break;


			case 2:
				System.out.println("선택 출력번호입력 : ");
				int no = sc.nextInt();
				TestDto dto = biz.selectOne(no);
				System.out.println(dto);
				break;



		   case 3: 
				System.out.println("추가할 번호 : ");
				 int insertno =sc.nextInt(); //int no 하면 안됨 case2에서 이미 써서
				System.out.println("추가할 이름 : ");
				String name = sc.next();
				System.out.println("추가할 전화번호 : ");
				String phone = sc.next();
				System.out.println("추가할 주소 : ");
				String addr = sc.next();

				TestDto insertDto = new TestDto(insertno, name, phone, addr);
			    int insertRes = biz.insert(insertDto);
				if (insertRes > 0) {
					System.out.println("insert 성공!!");
				} else {
					System.out.println("insert 실패!!");
					}break;


			case 4:
				System.out.println("몇번  데이터를 수정? : ");
				int updateno = sc.nextInt();
				System.out.println("수정할 이름  : ");
				String updatename = sc.next();
				System.out.println("수정할 번호  : ");
				String updatephone = sc.next();
				System.out.println("수정할 주소  : ");
 				String updateaddr = sc.next();

 				TestDto updateDto = new TestDto(updateno, updatename, updatephone, updateaddr);
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("update 성공!!");
				} else {
					System.out.println("update 실패!!");
				}
				break;



			case 5:
				System.out.println("삭제");
				System.out.println("삭제할 번호");
				int deleteno = sc.nextInt();

				int deleteRes = biz.delete(deleteno);
				if (deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 6:
				System.out.println("종료...");
				break;
			}
		}
	}
}
