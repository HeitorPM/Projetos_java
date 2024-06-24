package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Fornecedor;
import entities.Produto;

public class FornecedorRepository {

	public void exportarDados(Fornecedor fornecedor) throws Exception {

		PrintWriter writer = new PrintWriter(new File("C:\\Windows\\Temp\\cliente.txt"));

		writer.println("\nDados do fornecedor:\n");
		writer.println("\tId do fornecedor...: " + fornecedor.getIdFornecedor());
		writer.println("\tNome...............: " + fornecedor.getNome());
		writer.println("\tCNPj...............: " + fornecedor.getCnpj());
		writer.println("\tProdutos...........: " + fornecedor.getProdutos());

		for (Produto p : fornecedor.getProdutos()) {

			writer.println("\nDados do Produto:\n");
			writer.println("\tId do produto...: " + p.getIdProduto());
			writer.println("\tNome............: " + p.getNome());
			writer.println("\tPreco...........: " + p.getPreco());
			writer.println("\tQuantidade......: " + p.getQuantidade());

		}

		writer.flush();
		writer.close();

	}
}