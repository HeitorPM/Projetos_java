package br.com.cotiinformatica.dtos;

public class TarefasRelatorioDTO {

	private String dataMin;
	private String dataMax;

	public TarefasRelatorioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarefasRelatorioDTO(String dataMin, String dataMax) {
		super();
		this.dataMin = dataMin;
		this.dataMax = dataMax;
	}

	public String getDataMin() {
		return dataMin;
	}

	public void setDataMin(String dataMin) {
		this.dataMin = dataMin;
	}

	public String getDataMax() {
		return dataMax;
	}

	public void setDataMax(String dataMax) {
		this.dataMax = dataMax;
	}

}
