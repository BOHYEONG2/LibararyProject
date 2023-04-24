package library.vo;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String birthdate;
	private String phone;
	private String email;

	public MemberVO() {
		super();
	
	}

	public MemberVO(String id, String password, String name, String birthdate, String phone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	            this.password = password;
		 }
	     
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", birthdate=" + birthdate
				+ ", phone=" + phone + ", email=" + email + "]";
	}



	
}
	
