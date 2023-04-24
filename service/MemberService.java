package library.service;

import library.dao.MemberDAO;
import library.vo.MemberVO;

public class MemberService {

	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao = new MemberDAO();
	}
	
	public MemberService(MemberVO member) {
		
	}

	public void JoinMembership(MemberVO member) {
		memberDao.JoinMembership(member);
	}
	
	public void loginMember(MemberVO member) {
		memberDao.loginMember(member);
	}
	
	public boolean checkId(String id) {
		return memberDao.checkId(id);
	}

	public void modifyPassword(MemberVO member) {
		memberDao.modifyPassword(member);
	}
	public void modifyPhone(MemberVO member) {
		memberDao.modifyPhone(member);
	}

	public void modifyEmail(MemberVO member) {
		memberDao.modifyEmail(member);
		
	}

	public void deleteMember(MemberVO member) {
		memberDao.deleteMember(member);
		
	}
	
	
}

