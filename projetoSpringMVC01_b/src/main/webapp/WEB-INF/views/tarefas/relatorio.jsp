<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório</title>

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
		<h5>Relatório de tarefas</h5>
		<br/>
		
		<form id= "form-relatorio" autocomplete = "off">
			<div class = "row">
				<div class = "col-md-3">
					<label>Data de Início:</label>
					<input type="date" id="datamin" name= "datamin" class="form-control">
				</div>
				<div class = "col-md-3">
					<label>Data de término</label>
					<input type="date" id="datamax" name = "datamax" class="form-control">
				</div>
			</div>
			<div class="row-mt-3">
				<div class ="col-md-12">
					<input type="submit" value="Gerar Relatório" class="btn btn-success">
				
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
			
			$("#form-relatorio").validate(
			{
				//regras de validação
				rules : {
					"datamin" : { required: true},
					"datamax" : { required: true},					
				}
			}		
			
			);jquery.validate.min.js
		});

	</script>	
		
</body>
</html>
