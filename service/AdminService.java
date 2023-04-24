package library.service;

import library.dao.AdminDAO;
import library.vo.AdminVO;

public class AdminService {

	private AdminDAO adminDao;
	
	public AdminService() {
		adminDao = new AdminDAO();
	}
	
	public void AdminSign(AdminVO admin) {
		adminDao.AdminSign(admin);
	}
	
	public void AdminLogin(AdminVO admin) {
		adminDao.AdminLogin(admin);
	}
	public boolean checkId(String id) {
		return adminDao.checkId(id);
	}
	
	
}
