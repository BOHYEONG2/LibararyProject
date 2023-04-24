package library.ui;

import library.service.MemberService;
import library.vo.MemberVO;

public class UserInfo extends BaseUI {

	private MemberVO member;
	private MemberService memberService;
	
	public UserInfo(MemberVO member) {
		this.member = member;
		memberService = new MemberService(member);
	}
	public UserInfo() {}
	
	@Override
	public void execute() throws Exception {
	
		System.out.println("마이페이지 시스템 점검중입니다. 죄송합니다");
		MyPageUI mu = new MyPageUI();
		mu.execute();
//		System.out.println("사용자의 개인 정보를 출력합니다.");
//		System.out.println(member.toString());
		
	}

}
