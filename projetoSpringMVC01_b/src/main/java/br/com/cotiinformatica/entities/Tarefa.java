package br.com.cotiinformatica.entities;

import java.util.Date;

import br.com.cotiinformatica.enums.PrioridadeTarefa;

public class Tarefa {

	private Integer IdTarefa;
	private String Nome;
	private Date Data;
	private String Hora;
	private String Descricao;
	private PrioridadeTarefa prioridade;

	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer idTarefa, String nome, Date data, String hora, String descricao,
			PrioridadeTarefa prioridade) {
		super();
		IdTarefa = idTarefa;
		Nome = nome;
		Data = data;
		Hora = hora;
		Descricao = descricao;
		this.prioridade = prioridade;
	}

	public Integer getIdTarefa() {
		return IdTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		IdTarefa = idTarefa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public PrioridadeTarefa getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeTarefa prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Tarefa [IdTarefa=" + IdTarefa + ", Nome=" + Nome + ", Data=" + Data + ", Hora=" + Hora + ", Descricao="
				+ Descricao + ", getIdTarefa()=" + getIdTarefa() + ", getNome()=" + getNome() + ", getData()="
				+ getData() + ", getHora()=" + getHora() + ", getDescricao()=" + getDescricao() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
