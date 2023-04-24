package library.ui;

import java.util.Scanner;

import library.service.MemberService;
import library.vo.MemberVO;

public class ModifyUI extends BaseUI {

	private Scanner sc;
	private MemberVO member;
	private MemberService memberService;
	
	public ModifyUI(MemberVO member) {
		this.member = member;
		memberService = new MemberService(member);
	}
	
	public ModifyUI() {}

	@Override
	public void execute() throws Exception {
	
		System.out.println("시스템 점검중입니다. 죄송합니다");
		MyPageUI mu = new MyPageUI();
		mu.execute();
/*		System.out.println("1. 비밀번호");
		System.out.println("2. 전화번호");
		System.out.println("3. 메일주소");
		System.out.println("4. 뒤로가기");
		System.out.println("0. 종료");
		sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
			
		Kioskable ui = null;
		switch(choice) {
		case 1:
			String newPassword = scanStr("변경하실 비밀번호를 입력하세요 : ");
			member.setPassword(newPassword);
			memberService.modifyPassword(member);
			break;
		case 2:
			String newPhone = scanStr("변경하실 전화번호를 입력하세요 : ");
			member.setPhone(newPhone);
			memberService.modifyPhone(member);
		case 3:
			String newEmail = scanStr("변경하실 메일주소를 입력하세요 : ");
			member.setEmail(newEmail);
			memberService.modifyEmail(member);
		case 4:
			ui = new MyPageUI(member);
			break;
		case 0:
			ui = new ExitUI();
			break;
			
		}
		if(ui != null) {
			ui.execute();
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
*/
	}

}
