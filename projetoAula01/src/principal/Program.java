package principal;

import entities.Cliente;
import repositories.ClienteRepository;

public class Program {

	public static void main(String[] args) {
	
		System.out.println("Aula 01 - JAVA WEBDEVELOPER");
		
		Cliente cliente = new Cliente();
		
		//entrada de dados
			
		
		cliente.setIdCliente(1);
		cliente.setNome("Sergio Mendes");
		cliente.setEmail("sergio.coti@gmail.com");
		cliente.setCpf("123.456.789-00");
			
		System.out.println("\nDados do cliente:");
		System.out.println("\tId do cliente.....: " + cliente.getIdCliente());
		System.out.println("\tNome do cliente...: " + cliente.getNome());
		System.out.println("\tEmail do cliente..: " + cliente.getEmail());
		System.out.println("\tCPF do cliente....: " + cliente.getCpf());

		
		
		//criando um objeto para a classe ClienteRepository
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			clienteRepository.gravarArquivo(cliente);
			System.out.println("\nDados gravado com sucesso!");
		}
		catch(Exception e) {
			System.out.println("\nErro ao gravar arquivo!");
			System.out.println(e.getMessage());
		}
	}
}
