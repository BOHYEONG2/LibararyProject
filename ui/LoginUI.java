package library.ui;

import library.service.MemberService;
import library.vo.MemberVO;

public class LoginUI extends BaseUI {
	
	private MemberService memberService;
	
	public LoginUI() {
		memberService = new MemberService();
	}
	
	@Override
	public void execute() throws Exception {
		
		MemberVO member = new MemberVO();
		
		System.out.println("***로그인 페이지***");	
		
		String id = scanStr("아이디를 입력하세요 : ");
		String password = scanStr("비밀번호를 입력하세요 : ");
		while(!password.equals(password)) {
			password = scanStr("비밀번호를 다시 입력하세요 : ");
		}
		
		member.setId(id);
		member.setPassword(password);
		
		memberService.loginMember(member);
		
		
		
	}
}
