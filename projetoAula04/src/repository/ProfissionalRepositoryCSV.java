package repository;

import java.io.File;
import java.io.PrintWriter;

import entities.Profissional;
import interfaces.IProfissionalRepository;

public class ProfissionalRepositoryCSV implements IProfissionalRepository{

	@Override
	public void exportarDados(Profissional profissional) throws Exception {
		
		PrintWriter writer = new PrintWriter(new File("C:\\Windows\\Temp\\profissional.csv"));

		writer.write(profissional.getIdProfissional()
				+ ";" + profissional.getNome()
				+ ";" + profissional.getCpf()
				+ ";" + profissional.getTelefone()
				+ ";" + profissional.getTipoContratacao()
				);

		writer.flush();
		writer.close();
		
	}

	
}
