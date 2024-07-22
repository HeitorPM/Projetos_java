package br.com.cotiinformatica.dtos;

public class AccountLoginDTO {

	public String email;
	public String senha;

	public AccountLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountLoginDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "AccountLoginDTO [email=" + email + ", senha=" + senha + ", getEmail()=" + getEmail() + ", getSenha()="
				+ getSenha() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
