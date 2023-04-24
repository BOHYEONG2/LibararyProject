package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import library.ui.AdminUI;
import library.ui.UserUI;
import library.vo.AdminVO;
import library.vo.MemberVO;

public class AdminDAO {

	public boolean checkId(String id) {

		String sql = "SELECT * FROM t_manager  WHERE id = ? ";
	
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
	public void AdminSign(AdminVO admin) {
		
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into t_manager(id, password, name, birthdate, phone, email) ");
		sql.append(" values(?, ?, ?, ?, ?, ?) ");
		
		try( 
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			pstmt.setString(3, admin.getName());
			pstmt.setString(4, admin.getBirtdate());
			pstmt.setString(5, admin.getPhone());
			pstmt.setString(6, admin.getEmail());

			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void AdminLogin(AdminVO admin) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select id, password ");
		sql.append("   from t_manager ");
		sql.append("  where id = ? and password = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();	  
			PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
			) {	
			
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("ID또는 Password를 잘못 입력하셨습니다.");
			} else {
				System.out.println("환영합니다! " + admin.getId() + "님");
				AdminUI au = new AdminUI();
				au.execute();
			}
			
		     	} catch(Exception e) {
		     		e.printStackTrace();
		     	}			
	}

}
