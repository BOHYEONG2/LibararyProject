package library.vo;

public class AdminVO {

	private String id;
	private String password;
	private String name;
	private String birtdate;
	private String phone;
	private String email;
	
	public AdminVO() { }

	
	public AdminVO(String id, String password, String name, String birtdate, String phone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birtdate = birtdate;
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

	public String getBirtdate() {
		return birtdate;
	}

	public void setBirtdate(String birtdate) {
		this.birtdate = birtdate;
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
		return "AdminVO [id=" + id + ", password=" + password + ", name=" + name + ", birtdate=" + birtdate + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
