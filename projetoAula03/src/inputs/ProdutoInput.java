package inputs;

import javax.swing.JOptionPane;

public class ProdutoInput {

	public static Integer lerIdProduto() throws Exception {

		Integer idProduto = Integer.parseInt(JOptionPane.showInputDialog("Entre com o id do produto:"));

		if (idProduto > 0) {
			return idProduto;
		} else {
			throw new Exception("O id do produto devbe ser maior do que zero.");
		}
	}

	public static String lerNome() throws Exception {
		String nome = JOptionPane.showInputDialog("Entre com o nome do produto:");

		if (nome.trim().length() >= 6 && nome.trim().length() <= 150) {
			return nome;
		} else {
			throw new Exception("O nome do produto deve ster de 6 a 150 caracteres");
		}
	}

	public static Double lerPreco() throws Exception {
		Double preco = Double.parseDouble(JOptionPane.showInputDialog("Entre com o preço do produto:"));

		if (preco > 0) {
			return preco;
		} else {
			throw new Exception("O preço do produto deve ser maior do que zero");
		}
	}

	public static Integer lerQuantidade() throws Exception {

		Integer quantidade = Integer.parseInt(JOptionPane.showInputDialog("Entre com a quanitdade do produto"));

		if (quantidade > 0) {
			return quantidade;
		} else {
			throw new Exception("A quantidade do produto deve ser maior do que ze++ro.");
		}

	}

}
