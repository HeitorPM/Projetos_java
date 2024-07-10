package br.com.cotiinformatica.Intefaces;

import java.util.Date;
import java.util.List;

import br.com.cotiinformatica.entities.Tarefa;

															//obj, id
public interface ITarefaRepository extends ICrudRepository<Tarefa, Integer> {
	

	List<Tarefa> getByDatas(Date dataMin, Date dataMax) throws Exception;
}
