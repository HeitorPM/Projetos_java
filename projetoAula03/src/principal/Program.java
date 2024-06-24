package principal;

import java.util.ArrayList;
import java.util.List;

import entities.Fornecedor;
import entities.Produto;
import inputs.FornecedorInput;
import inputs.ProdutoInput;
import repositories.FornecedorRepository;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fornecedor fornecedor = new Fornecedor();

		try {

			fornecedor.setIdFornecedor(FornecedorInput.lerIdFornecedor());
			fornecedor.setNome(FornecedorInput.lerNome());
			fornecedor.setCnpj(FornecedorInput.lerCnpj());
			
			List<Produto> listaDeProdutos = new ArrayList<Produto>();
			
			
			System.out.println("\nLendo os daods do primeiro produto:\n");
			
			Produto produto1 = new Produto();
			
			produto1.setIdProduto(ProdutoInput.lerIdProduto());
			produto1.setNome(ProdutoInput.lerNome());
			produto1.setPreco(ProdutoInput.lerPreco());
			produto1.setQuantidade(ProdutoInput.lerQuantidade());
			
			listaDeProdutos.add(produto1);
			
			Produto produto2 = new Produto();

			
			produto2.setIdProduto(ProdutoInput.lerIdProduto());
			produto2.setNome(ProdutoInput.lerNome());
			produto2.setPreco(ProdutoInput.lerPreco());
			produto2.setQuantidade(ProdutoInput.lerQuantidade());
			
			listaDeProdutos.add(produto2);
			
			fornecedor.setProdutos(listaDeProdutos);
		
			
			FornecedorRepository fornecedorRepository = new FornecedorRepository();
			fornecedorRepository.exportarDados(fornecedor);


			System.out.println("\nDados gravado com sucesso");
		}

		catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}



	}

}
