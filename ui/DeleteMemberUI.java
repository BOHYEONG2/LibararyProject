package library.ui;

import library.dao.MemberDAO;
import library.vo.MemberVO;

public class DeleteMemberUI extends BaseUI {

	private MemberVO member;
	private MemberDAO memberDao;
	
	public DeleteMemberUI(MemberVO member) {
		this.member = member;
		memberDao = new MemberDAO(member);
	}

	@Override
	public void execute() throws Exception {
	
		String select = scanStr("정말 회원을 탈퇴하시겠습니까? (Y : 탈퇴), (N : 취소) : ");
		System.out.println("-------------------------------------------------------------");
		
		if(select.toUpperCase().equals("Y")) {
			memberDao.deleteMember(member);
		} else {
			KioskUI ku = new KioskUI();
			ku.execute();
		}
		
		
	}
	
	
}
