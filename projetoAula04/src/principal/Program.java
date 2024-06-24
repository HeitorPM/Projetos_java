package principal;

import controllers.ProfissionalController;
import repository.ProfissionalRepositoryCSV;

public class Program {

	public static void main(String[] args) {

		try {
			ProfissionalController profissionalController = new ProfissionalController(new ProfissionalRepositoryCSV());
			
			profissionalController.executarExportacao();
			
			System.out.println("Cadastro feito com sucesso!");
			
		} catch (Exception e) {
				System.out.println("\nErro: " + e.getMessage());
		}		
	}

}
