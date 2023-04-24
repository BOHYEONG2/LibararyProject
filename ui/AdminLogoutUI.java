package library.ui;

public class AdminLogoutUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		 
		String logout = scanStr("정말 로그아웃 하시겟습니까?\n(Y : 로그아웃), (N : 취소)");
	    if (logout.toUpperCase().equals("Y")) {
	    	KioskUI ku = new KioskUI();
	    	ku.execute();
	    } else if (logout.toUpperCase().equals("N")) {
	    	AdminUI au = new AdminUI();
	    	au.execute();
	    	} else {
	    		System.out.println("다시입력바랍니다.");
	    	}

	}

}
