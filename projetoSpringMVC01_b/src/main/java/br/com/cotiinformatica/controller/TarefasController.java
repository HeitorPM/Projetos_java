package br.com.cotiinformatica.controller;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.Intefaces.ITarefaRepository;
import br.com.cotiinformatica.dtos.TarefasCadastroDTO;
import br.com.cotiinformatica.dtos.TarefasEdicaoDTO;
import br.com.cotiinformatica.dtos.TarefasRelatorioDTO;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.enums.PrioridadeTarefa;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.reports.TarefasReport;

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

		// criado para fazer com que o enum/prioridade seja dinamico ou seja enciando
		// para a pagina o conteudo do ENUM(PrioridadeTarefa)
		modelAndView.addObject("prioridades", PrioridadeTarefa.values());

		return modelAndView;
	}
	// JSP file [/WEB-INF/views/tarefas-cadastro.jsp] not found

	@RequestMapping(value = "/cadastrar-tarefa", method = RequestMethod.POST)
	public ModelAndView cadastrarTarefa(TarefasCadastroDTO dto, HttpServletRequest request) {

		//captura usuario autenticado no sitema (ler da sessao)
		//o get attribute devolve sempre um tipo object, logo é necessario usar o 
		//(Usuario) para identificar o tipo de objeto como usuario
		//esse processo de chama cast
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		
		//HttpServletRequest request vai pegar a o user_auth, que é o usuario do sistema logado em sessão, la do account controller
		ModelAndView modelAndView = new ModelAndView("tarefas/cadastro");

		try {
			Tarefa tarefa = new Tarefa();
			tarefa.setUsuario(usuario);
			
			
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

	//trocamos get all por getByUsuario para pegar as tarefas referentes ao usuario que ta autenticado/logado na sessao 
	
	@RequestMapping("/tarefas-consulta") // aqui demonstra como vai ficar a rota url
	public ModelAndView consulta(HttpServletRequest request) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");// web-inf/views/tarefas/consulta.jsp rota da
		// pasta		

		try {// consultar todas atarefas no banco ded ados para entao exibilas na pagina de
				// consulta
			modelAndView.addObject("tarefas", tarefaRepository.getByUsuario(usuario.getIdUsuario()));

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping("/tarefas-relatorio") // aqui demonstra como vai ficar a rota url
	public ModelAndView relatorio() {
		// web-inf/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");
		
		
		modelAndView.addObject("relatorio-dto", new TarefasRelatorioDTO());

		return modelAndView;
	}

	@RequestMapping(value = "/gerar-relatorio", method = RequestMethod.POST) // aqui demonstra como vai ficar a rota url
	public ModelAndView gerarRelatorio(TarefasRelatorioDTO dto, HttpServletRequest request, HttpServletResponse response) {
		
		
		//capturar usuario autenteicado no sistema (ler da sessao)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");

		
		// web-inf/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/relatorio");
		modelAndView.addObject("relatorio-dto", new TarefasRelatorioDTO());

		try {
			// resgatar as datas obtidas no formulario
			Date dataMin = DateHelper.toDate(dto.getDataMin());
			Date dataMax = DateHelper.toDate(dto.getDataMax());
			
			// consultar no banco de dados as tarefas por periodo de data
			List<Tarefa> tarefas = tarefaRepository.getByDatas(dataMin, dataMax, usuario.getIdUsuario());

			// gerar relatorio pdf---> criada a partir da classe tarefasReport que tb foi criada aqui
			ByteArrayInputStream stream = TarefasReport.getPdf(dataMin, dataMax, tarefas, usuario);

			
			/*Download de um relatorio...
			HttpServletResponse --> Classe java utilizada para retornar a resposta ao
			navegador como por exemplo um download de arquivo*/
			
			// indicando pro navegador o tipo de arquivo
			response.setContentType("application/pdf");
			// attachment indica que vai ser um anexo, filename será o nome
			response.addHeader("Content-disposition", "attachment; filename=tarefas.pdf");
																							

			byte[] dados = stream.readAllBytes();// lendo o arquivo em memoria

			OutputStream out = response.getOutputStream();
			out.write(dados, 0, dados.length);
			out.flush();
			out.close();

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	// vai preencher a pagina de edicao quando clicar
	@RequestMapping("/tarefas-edicao")
	public ModelAndView edicao(Integer id, HttpServletRequest request) {

		//capturar o usuario autenticado no sistema (let da sessao)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");

		try {

			// puxa as informaçoes baseadas no ID
			Tarefa tarefa = tarefaRepository.getById(id);
			
			if(tarefa.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
				throw new Exception("Erro. A tarefa selecionada nao pertence ao usuario logado.");
			}

			// cria um dto e passa todas as informaçoes alteradas na tela,
			TarefasEdicaoDTO dto = new TarefasEdicaoDTO();
			dto.setIdTarefa(tarefa.getIdTarefa());
			dto.setNome(tarefa.getNome());
			dto.setData(DateHelper.toString(tarefa.getData()));
			dto.setHora(tarefa.getHora());
			dto.setDescricao(tarefa.getDescricao());
			dto.setPrioridade(tarefa.getPrioridade().toString());

			modelAndView.addObject("tarefas-dto", dto);
			modelAndView.addObject("prioridades", PrioridadeTarefa.values());

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	// vai salvar o que foi preenchido na pagina após alterar
	@RequestMapping(value = "/atualizar-tarefa", method = RequestMethod.POST) // rota url
	public ModelAndView atualizarTarefa(TarefasEdicaoDTO dto, HttpServletRequest request) {

		//capturar o usuario autenticado no sistema (let da sessao)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		
		// web-inf/views/tarefas/relatorio.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas/edicao");

		try {
			Tarefa tarefa = new Tarefa();
			tarefa.setUsuario(usuario);

			tarefa.setIdTarefa(dto.getIdTarefa());
			tarefa.setNome(dto.getNome());
			tarefa.setData(DateHelper.toDate(dto.getData()));
			tarefa.setHora(dto.getHora());
			
			tarefa.setDescricao(dto.getDescricao());
			tarefa.setPrioridade(PrioridadeTarefa.valueOf(dto.getPrioridade()));

			tarefaRepository.update(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa atualizada com sucesso!");

			modelAndView.addObject("tarefas-dto", dto);
			modelAndView.addObject("prioridades", PrioridadeTarefa.values());

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/tarefas-exclusao")
	public ModelAndView excluirTarefa(Integer id, HttpServletRequest request) {

		//capturar o usuario autenticado no sistema (let da sessao)
		Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");
		
		ModelAndView modelAndView = new ModelAndView("tarefas/consulta");

		try {
			Tarefa tarefa = tarefaRepository.getById(id);

			if(tarefa.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
				throw new Exception("Erro. A tarefa selecionada nao pertence ao usuario logado.");
			}
			
			tarefaRepository.delete(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa excluida com sucesso.");

			modelAndView.addObject("tarefas", tarefaRepository.getByUsuario(usuario.getIdUsuario()));

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

}
