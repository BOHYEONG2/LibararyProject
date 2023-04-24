package library.ui;

import library.service.MemberService;
import library.vo.MemberVO;

public class UserSignupUI extends BaseUI{
	
	
	private MemberService memberService;
	
	public UserSignupUI() {
		memberService = new MemberService();
	}
//	String code = "1234";
	@Override
	public void execute() throws Exception {
		
		MemberVO member = new MemberVO();
		
		System.out.println("회원가입을 시작합니다.");
		String id = scanStr("아이디를 입력하세요 : ");
		while(!memberService.checkId(id)) {
			id = scanStr("id를 입력하세요 : ");
		};
		String password = scanStr("비밀번호를 입력하세요 : ");
		String password2 = scanStr("비밀번호를 입력하세요 : ");
		while(!password.equals(password2)) {
			password2 = scanStr("비밀번호를 다시 입력하세요 : ");
		}
		String name = scanStr("이름을 입력하세요 : ");
		String birthdate = scanStr("생년월일을 입력하세요 : ");
		String phone = scanStr("핸드폰번호를 입력하세요 : ");
		String email = scanStr("email을 입력하세요 : ");
			
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirthdate(birthdate);
		member.setPhone(phone);
		member.setEmail(email);

		memberService.JoinMembership(member);
		
		System.out.println("회원가입에 성공하였습니다.");
		
	}
	

}
