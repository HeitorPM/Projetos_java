package br.com.cotiinformatica.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.Intefaces.ITarefaRepository;
import br.com.cotiinformatica.entities.Usuario;

@Controller
public class HomeController {

	// autowired serve para iniciar automaticamente, é um anotation esteriotipo do
	// Spring
	@Autowired
	private ITarefaRepository tarefaRepository;

	@RequestMapping(value = "/home")
	public ModelAndView test(HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("home");

		try {
			// obter o usuario autenticado na aplicação
			Usuario usuario = (Usuario) request.getSession().getAttribute("user_auth");

			// consultando os dados para geracao do grafico - vai jogar na variavel
			// dados-grafico o select
			modelAndView.addObject("dados_grafico", tarefaRepository.getGroupByPrioridade(usuario.getIdUsuario()));

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;

	}
}
