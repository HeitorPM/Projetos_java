package br.com.cotiinformatica.Intefaces;

import java.util.List;

/* <t> tipos generico que ira representar uma entidade
 * <ID> tipo generico que ira representar a chave primaria da entidade
 * */
public interface ICrudRepository <T, ID>{

	void create(T obj) throws Exception;
	void update(T obj)  throws Exception;
	void delete(T obj) throws Exception;
	
	List<T> getAll() throws Exception;

	T getById(Integer id) throws Exception;
	
}
