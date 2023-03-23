package rest.asii.model;


public class User {

	private int id;
	private String nom;
	private String login;
	private String passwd;
	private String role;
		
	public User() {}
	public User(int id, String nom, String login, String passwd, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.passwd = passwd;
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String pass) {
		this.passwd = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
