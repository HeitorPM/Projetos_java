package inputs;

import javax.swing.JOptionPane;

import enums.TipoContratacao;

public class FuncionarioInput {

	public static Integer lerIdProfissional() throws Exception {
		Integer idProfissional = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do profissional:"));

		// se entrar no throw, n passa pelo return
		if (idProfissional <= 0)
			throw new Exception("O ID do profissional deve ser maior do que zero.");
		return idProfissional;
	}

	public static String lerNome() throws Exception {
		String nome = JOptionPane.showInputDialog("Informe o nome do profissional:").trim();

		if (nome.length() != 11)
			throw new Exception("O cpf deve conter exatamente 11 digitos.");

		return nome;

	}

	public static String lerCpf() throws Exception {
		String cpf = JOptionPane.showInputDialog("Informe o cpf do profissional:").trim();

		if (cpf.length() != 11)
			throw new Exception("O cpf deve conter exatamente 11 digitos.");

		return cpf;

	}

	public static String lerTelefone() throws Exception {
		String telefone = JOptionPane.showInputDialog("Informe o telefone do profissional:").trim();

		if (telefone.length() != 9)
			throw new Exception("O telefone deve conter exatamente 9 digitos.");

		return telefone;

	}

	public static TipoContratacao lerTipoContratacao() throws Exception {

		Integer tipoContratacao = Integer
				.parseInt(JOptionPane.showInputDialog("Inform (1)CLT, (2)Estagio ou (3)Terceirizado"));

		switch (tipoContratacao) {
		case 1:
			return TipoContratacao.CLT;
		case 2:
			return TipoContratacao.CLT;
		case 3:
			return TipoContratacao.CLT;
		default:
			throw new Exception("Tipo de contratacao inválido.");
		}

	}

}
