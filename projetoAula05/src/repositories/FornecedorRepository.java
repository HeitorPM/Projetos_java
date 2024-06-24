package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Factories.ConnectionFactory;
import entities.Fornecedor;
import interfaces.IFornecedorRepository;

public class FornecedorRepository implements IFornecedorRepository {

	@Override
	public void create(Fornecedor obj) throws Exception {

		String query = "Insert into Fornecedor(NOME, CNPJ) values(?,?)";
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCnpj());
		
		statement.execute();
		statement.close();
		connection.close();
	}

	@Override
	public void update(Fornecedor obj) throws Exception {

		String query = "Update Fornecedor set NOME = ?, CNPJ= ? where IDFORNECEDOR = ?";
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, obj.getNome());
		statement.setString(2, obj.getCnpj());
		statement.setInt(3, obj.getIdFornecedor());

		
		statement.execute();
		statement.close();
		connection.close();		
	}

	@Override
	public void delete(Fornecedor obj) throws Exception {
		String query = "Delete from  Fornecedor where IDFORNECEDOR = ?";
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, obj.getIdFornecedor());

		
		statement.execute();
		statement.close();
		connection.close();				
	}

	@Override
	public List<Fornecedor> read() throws Exception {
		String query = "select * from  fornecedor";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while(result.next()) {
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setIdFornecedor(result.getInt("IDFORNECEDOR"));
			fornecedor.setNome(result.getString("NOME"));
			fornecedor.setCnpj(result.getString("CNPJ"));
			
			lista.add(fornecedor);
		}
		
		statement.close();
		result.close();
		
		connection.close();
		
		return lista;
	}

}
