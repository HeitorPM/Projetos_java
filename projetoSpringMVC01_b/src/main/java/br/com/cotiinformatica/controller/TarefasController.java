package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.Intefaces.ITarefaRepository;
import br.com.cotiinformatica.dtos.TarefasCadastroDTO;
import br.com.cotiinformatica.dtos.TarefasEdicaoDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DateHelper;

//precisa da annotation para conseguir associar ao controller
@Controller
public class TarefasController {

	// injeção de dependencia
	// n precisa abrir memoria mesmo sem ser estatico, ja que vc ja instanciou no
	// config
	// n é responsabilidade do controller intanciar
	// public ITarefaRepository getITarefaRepository() no config
	@Autowired // incializar de forma automatica
	private ITarefaRepository tarefaRepository;

	@RequestMapping("/tarefas-cadastro") // rota url
	public ModelAndView cadastro() {
		// web-inf/views/tarefas/cadastro.jsp pois ja consta no config o resto do
		// endereço
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		modelAndView.addObject("tarefas-dto", new TarefasCadastroDTO());

		//criado para fazer com que o enum/prioridade seja dinamico ou seja enciando para a pagina o conteudo do ENUM(PrioridadeTarefa)
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());

		return modelAndView;
	}
	// JSP file [/WEB-INF/views/tarefas-cadastro.jsp] not found

	@RequestMapping(value = "/cadastrar-tarefa", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(TarefasCadastroDTO dto) {

		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		try {
			Tarefa tarefa = new Tarefa();
			tarefa.setNome(dto.getNome());
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));

			tarefaRepository.create(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa cadastrada com sucesso.");
			dto = new TarefasCadastroDTO();
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		modelAndView.addObject("tarefas-dto", dto);
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());

		return modelAndView;
	}

	@RequestMapping("/tarefas-consulta") // aqui demonstra como vai ficar a rota url
	public ModelAndView consulta() {
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");// web-inf/views/tarefas/consulta.jsp rota da
																			// pasta

		try {// consultar todas atarefas no banco ded ados para entao exibilas na pagina de
				// consulta
			modelAndView.addObject("tarefas", tarefaRepository.getAll());

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping("/tarefas-relatorio") // aqui demonstra como vai ficar a rota url
	public ModelAndView relatorio() {
		// web-inf/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");

		return modelAndView;
	}

	
	//vai preencher a pagina de edicao quando clicar
	@RequestMapping("/tarefas-edicao")
	public ModelAndView edicao(Integer id) {

		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");

		try {

			//puxa as informaçoes baseadas no ID
			Tarefa tarefa = tarefaRepository.getById(id);

			//cria um dto e passa todas as informaçoes alteradas na tela, 
			TarefasEdicaoDTO dto = new TarefasEdicaoDTO();
			dto.setIdTarefa(tarefa.getIdTarefa());
			dto.setNome(tarefa.getNome());
			dto.setData(DateHelper.toString(tarefa.getData()));
			dto.setHora(tarefa.getHora());
			dto.setDescricao(tarefa.getDescricao());
			dto.setPrioridade(tarefa.getPrioridade().toString());


			modelAndView.addObject("tarefas-dto", dto);

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}



}
