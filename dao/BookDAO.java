package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import kr.ac.kopo.util.ConnectionFactory;
import library.ui.AdminUI;
import library.ui.UserUI;
import library.vo.BookVO;
import library.vo.MemberVO;
import library.vo.RentBookVO;

public class BookDAO {
	
	private MemberVO member;
    private UserUI us;
	
	public BookDAO() {}
	
	public BookDAO(MemberVO member) {
		this.member = member;
		us = new UserUI(member);
	}
	
	public void InsertBook(BookVO book) {
		
	StringBuilder sql = new StringBuilder();
	
	sql.append(" insert into t_book(isbn, title, author, publisher) ");
	sql.append(" values(?, ?, ?, ?) ");
	
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
								
			pstmt.executeUpdate();
			System.out.println("도서를 등록하였습니다.");
			System.out.printf("등록한 도서 :  도서번호 : %s번 제목 : %s 저자 : %s 출판사 : %s\n ", book.getIsbn(), book.getTitle(),book.getAuthor(),book.getPublisher());
			AdminUI au = new AdminUI();
			au.execute();
			
	} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 도서등록하기
	public void SearchBookList(BookVO book) {
		 
	      StringBuilder sql = new StringBuilder();
	      
	      sql.append("select * ");
	      sql.append("  from t_book ");
	      sql.append(" where title Like ? ");

	      try (
	    		Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    	  ) {
	         pstmt.setString(1, '%' + book.getTitle() + '%' );
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(!rs.next()) {
	             System.out.println("일치하는 도서가 없습니다. 잘못 입력하셨습니다.");
	         } else {
	             do {
	                 // 도서 정보 출력코드 작성
	            	 String isbn 		 = rs.getString("isbn");
	            	 String title  		 = rs.getString("title");
	            	 String author 		 = rs.getString("author");
	            	 String publisher    = rs.getString("publisher");
	            	 
	            	 book.setIsbn(isbn);
	            	 book.setTitle(title);
	            	 book.setAuthor(author);
	            	 book.setPublisher(publisher);
	            	 
	            	 System.out.printf("도서번호 : %s번 제목 : %s, 저자 : %s, 출판사 : %s\n", book.getIsbn(), book.getTitle(),book.getAuthor(),book.getPublisher());
	            	
	            	 us.execute();
	             } while (rs.next()); 
	       
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
// 도서검색하여찾기
	public void SelectAllBook(BookVO book) {
	
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select * ");
		sql.append("   from t_book ");

		
		try (
			Connection conn = new ConnectionFactory().getConnection();	 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
			) {	
			
			ResultSet rs = pstmt.executeQuery();
			
			 while(rs.next()) {
			        String isbn = rs.getString("isbn");
			        String title = rs.getString("title");
			        String author = rs.getString("author");
			        String publisher = rs.getString("publisher");
			        
			        book.setIsbn(isbn);
	                book.setTitle(title);
	            	book.setAuthor(author);
	            	book.setPublisher(publisher);
			        
			        System.out.printf("도서번호 : %s번 제목 : %s, 저자 : %s, 출판사 : %s\n", book.getIsbn(), book.getTitle(),book.getAuthor(),book.getPublisher());
			 }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		// 도서전체목록출력
		
	
	}

	public void getBookInfo(BookVO isbn) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select * ");
		sql.append("   from t_book ");
		sql.append("  where isbn = ? ");
		
		try (
		    	   Connection conn = new ConnectionFactory().getConnection();
		           PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		      ) {
			
					pstmt.setString(1, isbn.getIsbn());
					
					ResultSet rs = pstmt.executeQuery();
					
					if(!rs.next()) {
						System.out.println("존재하지 않는 도서 isbn입니다.");
					} else {
						String is = 		rs.getString("isbn");
						String title =      rs.getString("title");
						String author =     rs.getString("author");
						String pub =        rs.getString("publisher");
						
						isbn.setIsbn(is);
						isbn.setTitle(title);
						isbn.setAuthor(author);
						isbn.setPublisher(pub);
						
						rentBook(isbn);
						
					}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rentBook(BookVO isbn) {
		
	      StringBuilder sql = new StringBuilder();

	      sql.append(" insert into t_rentbook(id, isbn, title, author, publisher, rentdate) ");
	      sql.append(" values(?, ?, ?, ?, ?, ?) ");
	      
	      
	      try (
	    	   Connection conn = new ConnectionFactory().getConnection();
	           PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	      ) {
	    	  
	    	  LocalDateTime now = LocalDateTime.now();
	    	  String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    	  
	    	  pstmt.setString(1, member.getId());
	    	  pstmt.setString(2, isbn.getIsbn());
	    	  pstmt.setString(3, isbn.getTitle());
	    	  pstmt.setString(4, isbn.getAuthor());
	    	  pstmt.setString(5, isbn.getPublisher());
	    	  pstmt.setString(6, date);
	    	  
	    	  pstmt.executeUpdate();
	    	  
	    	  System.out.println("도서 대여를 완료했습니다.");
	    	  System.out.println("==============================");
	          System.out.println("ISBN: " + isbn.getIsbn());
	          System.out.println("도서명: " + isbn.getTitle());
	          System.out.println("저자: " + isbn.getAuthor());
	          System.out.println("출판사: " + isbn.getPublisher());
	          String rentDate = date.format(date);
	          System.out.println("대여 일자: " + rentDate);
	          RentList();
	          
	    	  us.execute();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
		private void RentList() {
		
	}

		public boolean rentalCheck(String isbn) {
		
		StringBuilder sql = new StringBuilder();
		int cnt = 0;
		
		sql.append(" select isbn ");
		sql.append("   from t_RentBook ");
		sql.append("  where isbn = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
				pstmt.setString(1, isbn);
				
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
		
		public void returnBooks(RentBookVO isbn) {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append(" delete ");
			sql.append("   from t_RentBook ");
			sql.append("  where isbn = ? ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					pstmt.setString(1, isbn.getIsbn());
					
					ResultSet rs = pstmt.executeQuery();
					
					if(!rs.next()) {
						System.out.println("대여 목록에 존재하지 않는 번호입니다.");
					} else {
						
						returnBook(isbn);
					}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void returnBook(RentBookVO isbn) {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("  select * ");
			sql.append("    from t_book ");
			sql.append("   where isbn = ? ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					
					pstmt.setString(1, isbn.getIsbn());
					
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						
						String is      = rs.getString("isbn");
						String title   = rs.getString("title");
						String author  = rs.getString("author");
						String pub     = rs.getString("publisher");
						
						BookVO br = new BookVO();
						
						br.setIsbn(is);
						br.setTitle(title);
						br.setAuthor(author);
						br.setPublisher(pub);
						
						System.out.println(br.getTitle() + "책이 반납되었습니다.");
		
					}
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void deleteBook(BookVO isbn) {
		
		 StringBuilder sql = new StringBuilder();

	      sql.append(" delete from t_book where isbn = ? ");
			
			
	      
	      try (
	    	   Connection conn = new ConnectionFactory().getConnection();
	           PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	      ) {
	    	  
	    	  pstmt.setString(1, isbn.getIsbn()); 
	    	
	    	  
	    	  ResultSet rs = pstmt.executeQuery();
	    	  
	    	  if(!rs.next()) {
					System.out.println("존재하지 않는 도서입니다");
				} else {
					System.out.println("도서 삭제 완료.");
					AdminUI au = new AdminUI();
					au.execute();

	    	  pstmt.executeUpdate();

	    	  us.execute();

				}
		} catch (Exception e) {
	         e.printStackTrace();
	      
	   }
		
	}

}
