package repository;

import java.io.File;
import java.io.PrintWriter;

import entities.Profissional;
import interfaces.IProfissionalRepository;

public class ProfissionalRepositoryTXT implements IProfissionalRepository {

	@Override
	public void exportarDados(Profissional profissional) throws Exception {

		PrintWriter writer = new PrintWriter(new File("C:\\Windows\\Temp\\profissional.txt"));

		writer.write("\nID do profissional...: " + profissional.getIdProfissional());
		writer.write("\nNome.................: " + profissional.getNome());
		writer.write("\nCpf..................: " + profissional.getCpf());
		writer.write("\nTelefone.............: " + profissional.getTelefone());
		writer.write("\nTipo de contrtação...: " + profissional.getTipoContratacao());

		writer.flush();
		writer.close();
	}

}
