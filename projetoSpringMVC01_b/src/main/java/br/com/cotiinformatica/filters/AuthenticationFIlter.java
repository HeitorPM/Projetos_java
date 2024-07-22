package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFIlter
 */
public class AuthenticationFIlter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFIlter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//tratamento para atualizar estes objetos request e response para os tipo :HttpServletRequest e HttpServletResponse  
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse  resp = (HttpServletResponse) response;
		
		//definir quais sao as urls permitidas no sistema
		// nao precisam que o usuario esteja autenticado...
		
		List<String> urlsPermitidas = new ArrayList<String>();
		
		urlsPermitidas.add("/");
		urlsPermitidas.add("/login");
		urlsPermitidas.add("/register");
		urlsPermitidas.add("/autenticar-usuario");
		urlsPermitidas.add("/cadastrar-usuario");
		urlsPermitidas.add("/password-recover");
		urlsPermitidas.add("/recuperar-senha");

		
		//verificando se a requisicao que o filter esta interceptand
		//nao e de nhuma das urls contidas na lits
		if(!urlsPermitidas.contains(req.getServletPath())) {
			
			//verifica se o usuario não esta autenticado em sessão (user_auth)
			if(req.getSession().getAttribute("user_auth")== null) {
				//redireciona para pagina inicial do projeto
				resp.sendRedirect("/projetoSpringMVC01_b/");
			}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
