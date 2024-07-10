package br.com.cotiinformatica.dtos;

public class TarefasCadastroDTO {

	private String nome;
	private String data;
	private String hora;
	private String descricao;
	private String prioridade;

	public TarefasCadastroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarefasCadastroDTO(String nome, String data, String hora, String descricao, String prioridade) {
		super();
		this.nome = nome;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "TarefasCadastroDTO [nome=" + nome + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao
				+ ", prioridade=" + prioridade + "]";
	}

}
