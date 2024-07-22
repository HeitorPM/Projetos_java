package br.com.cotiinformatica.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.cotiinformatica.Intefaces.ITarefaRepository;
import br.com.cotiinformatica.Intefaces.IUsuarioRepository;
import br.com.cotiinformatica.Repository.TarefaRepository;
import br.com.cotiinformatica.Repository.UsuarioRepository;

@Configuration
@ComponentScan(basePackages = "br.com.cotiinformatica")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");//instalado no pom.xml
		//dataSource.setUrl("jdbc:mysql://localhost:3306/bdprojeto05?useTimezone=true&serverTimezone=UTC&useSSL=false");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bd_projetoSpringmvc01?useTimezone=true&serverTimezone=UTC&useSSL=false");

		
		dataSource.setUsername("root");
		dataSource.setPassword("120322");
		
		return dataSource;
	}
	
	/*
	 * Configuração para que o SPring possa incializar de forma automatica as interfaces / classes da camada de repostirio (injelçao de dependencia)
	 * */
	@Bean
	public ITarefaRepository getITarefaRepository() {
		return new TarefaRepository(getDataSource());
	}
	
	@Bean
	public IUsuarioRepository getIUsuarioRepository() {
		return new UsuarioRepository(getDataSource());
	}
	

}
