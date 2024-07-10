<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<style>
	label.error {color : #d9534f;}
	input.error, textarea.error, select.error { border: 1px solid #d9534f;}
</style>


</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp"/>
	
	<div class="container mt-3">
		<h5>Atualizar dados da tarefa</h5>
		<br/>
		
		<form id = "form-edicao" action="atualizar-tarefa" method="post" autocomplete = "off"> <!--pro jquery validar e acessar o formulario ele precisa do id dele e dos inputs(nesse caso dos ids e do nome) -->
			
			<!-- campo oculto -->
			<form:input type="hidden" path="tarefas-dto.idTarefa"/>
			

			<!-- LINHA -->
			<div class="row">
				<div class ="col-md-6">
					<label>Nome da tarefa:</label>
					<form:input path="tarefas-dto.nome" type="text" id="nome" name="nome" class="form-control"/>
					
				</div>
				<div class="col-md-3">
					<label>Data da tarefa:</label>
					<form:input path="tarefas-dto.data" type ="date" id="data" name="data" class="form-control"/>
					
				</div>
				<div class="col-md-3">
					<label>Hora da tarefa:</label>
					<form:input path="tarefas-dto.hora" type="time" id="hora" name="hora" class="form-control"/>
				</div>
						
			</div>
			<!-- LINHA -->
			<div class="row mt-3"> <!-- mt-2 margin top 2 -->
				<div class ="col-md-6">				
					<label>Descrição da tarefa:</label>
					<form:textarea path="tarefas-dto.descricao" id="descricao" name="descricao" class="form-control"></form:textarea>								
				</div>
				
				
				<div class="col-md-3">
					<label>Prioridade da tarefa:</label>
					<form:select path="tarefas-dto.prioridade" id="prioridade" name="prioridade" class="form-select">
						<option value = "">Escolha uma opção</option>
						<form:options items="${prioridades}"/>
					</form:select>	
				</div>
				
			</div>			
				<!-- LINHA -->
			<div class="row mt-3"> 
				<div class ="col-md-6">				
					<!-- botao -->
					<input type = "submit" value = "Salvar alterações" class="btn btn-success">
					<!-- botao -->
					<a href="/projetoSpringMVC01_b/tarefas-consulta" class="btn btn-light">Cancelar</a>								
				
				</div>
			</div>								
		</form>		
	</div>

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>	
	
	<script>
		//iniciando o jquery, quando a pagina abrir, faça
		$(document).ready(function(){
			
			$("#form-edicao").validate(
			{
				//regras de validação
				rules : {
					"nome" : { required: true, minlength: 6, maxlength: 150},
					"data" : { required: true},
					"hora" : {required: true},
					"descricao" : {required: true, minlength: 10, maxlength: 500},
					"prioridade" : {required: true}
					
				}
			}		
			
			);
		});

	</script>	
	
</body>
</html>
