package inputs;

import javax.swing.JOptionPane;

public class FornecedorInput {

	public static Integer lerIdFornecedor() throws Exception {

		Integer idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id do fornecedor:"));

		if (idFornecedor > 0) {
			return idFornecedor;
		} else {
			throw new Exception("O id deve do fornecedor deve ser maior que 0");
		}
	}

	public static String lerNome() throws Exception {
		String nome = JOptionPane.showInputDialog("Entre com nome d o fornecedor");

		if (nome.trim().length() >= 6 && nome.trim().length() <= 150) {
			return nome;
		} else {
			throw new Exception("O nome deve conter no mínimo 6 e no máximo 150 caracteres.");
		}

	}

	public static String lerCnpj() throws Exception {

		String cnpj = JOptionPane.showInputDialog("Entre com o cnpj do fornecedor:");
		if (cnpj.trim().length() >= 14 && cnpj.trim().length() <= 18) {
			return cnpj;
		} else {
			throw new Exception("CNPJ deve conter de 14 a 18 caracteres.");
		}

	}

}
