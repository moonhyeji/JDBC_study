package com.kh.dto;

//DTO (Data Transfer Object) (= VO :Value Object): db 에 있는  data를 저장,전달할수있는 객체
//db 에 있는  data 를 전달 하기 때문에 db의 컬럼과 같은 이름으로 필드를 만든다.
public class TestDto {


	//같은 클래스 내(private)에서 접근 가능한 전역변수들 아래처럼 컬럼과 같은 이름으로 필드를 만든다.*/
	//일반적으로 필드의 값을 보호하기 위해 private 접근제한자로 필드값을 보호한다.
	private int no;    //NO NUMBER PRIMARY KEY,
	private String name;   //NAME VARCHAR2(100) NOT NULL,
	private String phone;  //PHONE VARCHAR2(20) NOT NULL,
	private String addr;   //ADDR VARCHAR2(1000) NOT NULL


	// 기본생성자
	//아래 (파라미터 4개짜리 생성자)가 있기 때문에 자바에서 자동으로 만들어주지 않아서 내가만듦.
	//public(어디서나)에서 TestDto(인자가없는)를 호출해 줄 수 있도록 하기 위해서
	public TestDto() {
	} //TestDto()

	// 필드를 초기화하는 생성자 (파라미터 4개짜리 생성자)
	public TestDto(int no, String name, String phone, String addr) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}



	//모든 필드의 getter/setter : 변수는 숨기고 메서드를 공개하여 외부에서 메서드를 통해 변수에 접근하도록 한다.
	//위 필드에서 private로 필드값을 선언했기 때문에 ,외부에서 필드의 값을 읽거나 쓸수가 없다.
	//따라서, 외부에서 필드의 값을 읽거나 쓰도록 해주기 위해서 getter & setter를 써서 방법을 제공해준다.



	// getter를 통해 데이터를 우회해서 가져오고
	// setter를 통해 데이터 접근, 값 변경


	//get_() 메서드 : private 변수에 저장된 값을 리턴 (가져옴)
	public int getNo() {  //private 변수에 저장된 no값 리턴
		return no;
	}
	//Set_() Method: 변수에 값을 넣음(변경,저장),(외부에서 들어온 매개값을 검증하여 유효한 값만 데이터로 저장)
	public void setNo(int no) {
		this.no = no;   //<- 매개변수로 넘어온 no을 멤버변수인 no에 대입하라

		//자바에서의 this는 객체 자신을 가리킨다,
		//매개변수명(= no;)과 객체가 가진 멤버변수명(this.no 클래스의 필드에서 선언한 변수명)이
		//같을 때 구분하기위한 용도로 사용됨
	}
	public String getName() { //private 변수에 저장된 name값을 리턴
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() { //private 변수에 저장된 phone값을 리턴
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {  //private 변수에 저장된 addr값을 리턴
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

   /*toString
	 1.toString()을 사용하는 이유 = 메서드를 통해 생성된 객체의 상태를 쉽게 파악할 수 있다.(값이들어갔나 안들어갔나 확인가능)
	2.toString을 재정의 하지 않는다면 호출한 클래스의 주소값이 출력된다.
	따라서, toString()은 어떤 객체의 정보를 문자열 형태로 표현하기 위해 재정의해준다.*/
	@Override   // toString 재정의 해서 사용 한다
	public String toString() {
		return String.format("%2d %5s %10s %10s", no, name, phone, addr);
		// String.format("문자열형태",변수):문자열 형태를 지정하는 함수
		// (no, name, phone, addr)을  %2d %5s %10s %s의 형식으로 사용하겠다.
		// %d (10진수 형식) , %s (문자열 형식)
	}
}
