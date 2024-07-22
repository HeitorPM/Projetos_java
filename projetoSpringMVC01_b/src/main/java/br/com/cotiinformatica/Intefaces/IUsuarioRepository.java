package br.com.cotiinformatica.Intefaces;

import br.com.cotiinformatica.entities.Usuario;

//o integer do parametro é referente o id que vamos pegar 
public interface IUsuarioRepository extends ICrudRepository<Usuario, Integer>{

	//metodo para pegar o usuario pelo email
	Usuario getByEmail(String email) throws Exception;
	
	Usuario getByEmailSenha(String email, String senha) throws Exception;
	
}
