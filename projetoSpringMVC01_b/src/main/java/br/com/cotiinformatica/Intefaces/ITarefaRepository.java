package br.com.cotiinformatica.Intefaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.dtos.PrioridadeTarefaDTO;
import br.com.cotiinformatica.entities.Tarefa;

															//obj, id
public interface ITarefaRepository extends ICrudRepository<Tarefa, Integer> {

	//metodo abstrato que sera utilizado pela pagina de consulta de tarefas
	List<Tarefa> getByUsuario(Integer idUsuario) throws Exception;

	//metodo abstrato que sera utilizado pela pagina de relatorio de tarefas
	List<Tarefa> getByDatas(Date dataMin, Date dataMax, Integer idUsuario) throws Exception;
	
	//metodo abstrato que sera utilizado para retornar os dados do grafico
	List<PrioridadeTarefaDTO> getGroupByPrioridade(Integer idUsuario) throws Exception;
	
}
