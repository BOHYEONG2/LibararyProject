package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import library.ui.KioskUI;
import library.ui.UserUI;
import library.vo.MemberVO;

public class MemberDAO {
	
	Scanner sc = new Scanner(System.in);
	private MemberVO member;
	
	public MemberDAO(MemberVO member) {
		this.member = member;
	}
	
	public MemberDAO() {  }

	public void JoinMembership(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into t_membership(id, password, name, birthdate, phone, email) ");
		sql.append(" values(?, ?, ?, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getBirthdate());
				pstmt.setString(5, member.getPhone());
				pstmt.setString(6, member.getEmail());
							
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
		
	public void loginMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select * ");
		sql.append("   from t_membership ");
		sql.append("  where id = ? and password = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();	 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
			) {	
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("ID또는 Password를 잘못 입력하셨습니다.");
			} else {
				System.out.println("환영합니다! " + member.getId() + "님");
				
				
				String id 			= rs.getString("id");
				String password 	= rs.getString("password");
				String name			= rs.getString("name");
				String brith		= rs.getString("birthdate");
				String email		= rs.getString("email");
				String phone		= rs.getString("phone");
				
				member.setId(id);
				member.setPassword(password);
				member.setName(name);
				member.setBirthdate(brith);
				member.setEmail(email);
				member.setPhone(phone);
				
				UserUI uu = new UserUI(member);
				uu.execute();

				
			}
			
		     	} catch(Exception e) {
		     		e.printStackTrace();
		     	}			
	}

	private String scanStr(String string) {
		
		return null;
	}

	public boolean checkId(String id) {

		String sql = "SELECT * FROM t_membership  WHERE id = ? ";
	
		try( 
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복되는 아이디가 있습니다.");
			} else {
				System.out.println("사용가능한 아이디 입니다. ");
				return true;
	         }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
		public void userInfo(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select * ");
		sql.append("   from t_membership ");
		sql.append("  where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				
				pstmt.setString(1, member.getId());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					String id 			= rs.getString("id");
					String Password 	= rs.getString("password");
					String name			= rs.getString("name");
					String birth		= rs.getString("birhdate");
					String phone		= rs.getString("phone");
					String email		= rs.getString("email");
					
					member.setId(id);
					member.setPassword(Password);
					member.setName(name);
					member.setBirthdate(birth);
					member.setPhone(phone);
					member.setEmail(email);
					
					System.out.println(member.toString());
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifyPassword(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update t_membership ");
		sql.append("    set password = ? ");
		sql.append("  where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				
				pstmt.setString(1, member.getPassword());
				pstmt.setString(2, member.getId());
				
				pstmt.executeUpdate();
				
				System.out.println("-------------------------------------------------------------");
				System.out.println("\t      비밀번호가 변경되었습니다. ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void modifyPhone(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update t_membership ");
		sql.append("    set phone = ? ");
		sql.append("  where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				
				pstmt.setString(1, member.getPhone());
				pstmt.setString(2, member.getId());
				
				pstmt.executeUpdate();
				
				System.out.println("-------------------------------------------------------------");
				System.out.println("\t      전화번호가 변경되었습니다. ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void modifyEmail(MemberVO member) {
	
		StringBuilder sql = new StringBuilder();
		
		sql.append(" update t_membership ");
		sql.append("    set email = ? ");
		sql.append("  where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getId());
				
				pstmt.executeUpdate();
				
				System.out.println("-------------------------------------------------------------");
				System.out.println("\t      전화번호가 변경되었습니다. ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void RentList(MemberVO member) {
	      StringBuilder sql = new StringBuilder();
	      sql.append("select * from Rent_book where = id ? ");
	      try (Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	    	 pstmt.setString(1, member.getId());

	         ResultSet rs = pstmt.executeQuery();
	         System.out.println("현재 대여중인 도서목록입니다.");
	         System.out.println("**************************************************************");
	         System.out.println("ISBN\t제목\t저자\t출판사\trent_date");
	         while (rs.next()) {
	            String isbn 		= rs.getString("ISBN");
	            String title 		= rs.getString("title");
	            String author 		= rs.getString("author");
	            String publisher	= rs.getString("publisher");
	            Date   rentdate 	= rs.getDate("rentDate");

	            System.out.println("--------------------------------------------------------------");
	            System.out.println(isbn + "\t" + title + "\t" + author + "\t" + publisher + "\t" + rentdate);
	         }
	         System.out.println("**************************************************************");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public void deleteMember(MemberVO member) {
		
			StringBuilder sql = new StringBuilder();
			
			sql.append(" delete ");
			sql.append("   from t_membership ");
			sql.append("  where id = ? ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
				
					pstmt.setString(1, member.getId());
					
					if(deleteMemberRentalCheck(member)) {
						System.out.println("\t\t회원 탈퇴가 정상정으로 완료 되었습니다.");
						pstmt.executeUpdate();
						KioskUI ku = new KioskUI();
						ku.execute();
					} else {
						System.out.println("\t  현재 대여중인 도서가 있으므로 회원 탈퇴가 취소됩니다.");
						System.out.println("-------------------------------------------------------------");
						UserUI uu = new UserUI(member);
						uu.execute();
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public boolean deleteMemberRentalCheck(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		int cnt = 0;
		
		sql.append(" select id ");
		sql.append("   from t_rentbook ");
		sql.append("  where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
				pstmt.setString(1, member.getId());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					cnt++;
				}
				
				if(cnt == 0) {
					return true;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}

	}
	
	
	

