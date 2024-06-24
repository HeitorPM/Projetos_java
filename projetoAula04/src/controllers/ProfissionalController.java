package controllers;

import entities.Profissional;
import inputs.ProfissionalInput;
import interfaces.IProfissionalRepository;

public class ProfissionalController {

	private IProfissionalRepository profissionalRepository;

	public ProfissionalController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfissionalController(IProfissionalRepository profissionalRepository) {
		super();
		this.profissionalRepository = profissionalRepository;
	}

	public void executarExportacao() throws Exception {

		Profissional profissional = new Profissional();

		profissional.setIdProfissional(ProfissionalInput.lerIdProfissional());
		profissional.setNome(ProfissionalInput.lerNome());
		profissional.setCpf(ProfissionalInput.lerCpf());
		profissional.setTelefone(ProfissionalInput.lerTelefone());
		profissional.setTipoContratacao(ProfissionalInput.lerTipoContratacao());

		profissionalRepository.exportarDados(profissional);
	}

}
