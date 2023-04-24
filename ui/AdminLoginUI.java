package library.ui;

import library.service.AdminService;
import library.vo.AdminVO;


public class AdminLoginUI extends BaseUI {
	
	private AdminService adminService;


	public AdminLoginUI() {
		adminService = new  AdminService();
	}
	
	@Override
	public void execute() throws Exception {
		
		AdminVO admin = new AdminVO();
		
		System.out.println("***로그인 페이지***");	
		
		String id = scanStr("아이디를 입력하세요 : ");
		String password = scanStr("비밀번호를 입력하세요 : ");
		
		admin.setId(id);
		admin.setPassword(password);
		
		adminService.AdminLogin(admin);
		

	}
	
}
