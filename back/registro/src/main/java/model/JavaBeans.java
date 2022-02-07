package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String idade;
	private String genero;
	private String telefone;
	private String email;
	private String cpf;
	
	
	public JavaBeans() {
		super();
		
	}
	
	
	public JavaBeans(String idcon, String nome, String idade, String genero, String telefone, String email,
			String cpf) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}


	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
