package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Factories.ConnectionFactory;
import entities.Fornecedor;
import entities.Produto;
import interfaces.IProdutoRepository;

public class ProdutoRepository implements IProdutoRepository {

	@Override
	public void create(Produto obj) throws Exception {
		String query = "INSERT INTO FORNECEDOR(NOME, PRECO, QUANTIDADE, IDFORNECEDOR) VALUES (?,?,?,?)";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, obj.getNome());
		statement.setDouble(2, obj.getPreco());
		statement.setInt(3, obj.getQuantidade());
		statement.setInt(4, obj.getFornecedor().getIdFornecedor());

		statement.execute();
		statement.close();

		connection.close();

	}

	@Override
	public void update(Produto obj) throws Exception {
		String query = "Update Produto set NOME =?, PRECO = ?, QUANTIDADE =? , IDFORNECEDOR = ? where idproduto = ? ";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, obj.getNome());
		statement.setDouble(2, obj.getPreco());
		statement.setInt(3, obj.getQuantidade());
		statement.setInt(4, obj.getFornecedor().getIdFornecedor());
		statement.setInt(5, obj.getIdProduto());

		statement.execute();
		statement.close();

		connection.close();

	}

	@Override
	public void delete(Produto obj) throws Exception {
		String query = "Delete from Produto where idproduto = ";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		statement.setInt(1, obj.getIdProduto());
		statement.execute();
		statement.close();

		connection.close();

	}

	// QCS

	@Override
	public List<Produto> read() throws Exception {

		String query = "Select * from VW_produtofornecedor";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (result.next()) {
			Produto produto = new Produto();
			produto.setFornecedor(new Fornecedor());

			produto.setIdProduto(result.getInt("IDPRODUTO"));
			produto.setNome(result.getString("NOME"));
			produto.setPreco(result.getDouble("PRECO"));
			produto.setQuantidade(result.getInt("QUANTIDADE"));
			produto.getFornecedor().setIdFornecedor(result.getInt("IDFORNECEDOR"));
			produto.getFornecedor().setNome(result.getString("nomefornecedor"));
			produto.getFornecedor().setCnpj(result.getString("CNPJ"));			
			
			lista.add(produto);
		}
		statement.close();
		result.close();

		connection.close();

		return lista;

	}

}
