package br.com.cotiinformatica.dtos;

public class AccountRegisterDTO {

	public String nome;
	public String email;
	public String senha;
	public String senhaConfirmacao;

	public AccountRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountRegisterDTO(String nome, String email, String senha, String senhaConfirmacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.senhaConfirmacao = senhaConfirmacao;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	@Override
	public String toString() {
		return "AccountRegisterDTO [email=" + email + ", nome=" + nome + ", senha=" + senha + ", senhaConfirmacao="
				+ senhaConfirmacao + ", getEmail()=" + getEmail() + ", getNome()=" + getNome() + ", getSenha()="
				+ getSenha() + ", getSenhaConfirmacao()=" + getSenhaConfirmacao() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
