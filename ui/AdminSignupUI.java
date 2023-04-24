package library.ui;

import library.service.AdminService;
import library.vo.AdminVO;

public class AdminSignupUI extends BaseUI {

	private AdminService adminService;
	
	public AdminSignupUI() {
		adminService = new AdminService();
	}

	@Override
	public void execute() throws Exception {
		
		AdminVO admin = new AdminVO();
		
		System.out.println("관리자로 회원가입을 시작합니다");
		String id = scanStr("id를 입력하세요 : ");
		while(!adminService.checkId(id)) {
			id = scanStr("id를 입력하세요 : ");
		};
		String password = scanStr("password를 입력하세요 : ");
		String password2 = scanStr("password를 한번더 입력하세요 : ");
		while(!password.equals(password2)) {
			password2 = scanStr("비밀번호를 다시 입력하세요 : ");
		}
		String name = scanStr("이름을 입력하세요 : ");
		String birthdate = scanStr("생년월일을 입력하세요 : ");
		String phone = scanStr("핸드폰번호를 입력하세요 : ");
		String email = scanStr("email을 입력하세요 : ");
		
		admin.setId(id);
		admin.setPassword(password);
		admin.setName(name);
		admin.setBirtdate(birthdate);
		admin.setPhone(phone);
		admin.setEmail(email);
		
		adminService.AdminSign(admin);
		
		System.out.println("관리자 회원가입에 성공하였습니다.");
	
		
	}
}
