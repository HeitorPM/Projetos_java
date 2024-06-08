package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Cliente;

public class ClienteRepository {

	//metodo para exportar os dados do cliente para um arquivo de extensao .txt
	
	public void gravarArquivo(Cliente cliente) throws Exception{
		
		PrintWriter printWriter = new PrintWriter(new File("C:\\Windows\\Temp\\cliente.txt"));
		
		//c:\\temp\\cliente.txt
		printWriter.write("\nDADOS DO CLIENTE:");
		printWriter.write("\n\tId do CLiente.....: " + cliente.getIdCliente());
		printWriter.write("\n\tNome do CLiente...: " + cliente.getNome());
		printWriter.write("\n\tEmail do CLiente..: " + cliente.getEmail());
		printWriter.write("\n\tCpf do CLiente....: " + cliente.getCpf());
		
	//salvar e fechar o arquivo 
		printWriter.flush();
		printWriter.close();
		

		
	}                         
}
