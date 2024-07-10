<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<!-- adicionando referencia para as bibliotecas de CSS (folha de estilo) -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<!-- colocando o css referente ao datatables -->
<link rel="stylesheet" href = "resources/css/dataTables.dataTables.min.css" />


</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp"/>
	<jsp:include page="/WEB-INF/views/components/mensagens.jsp"/>
	
	
	<div class="container mt-3">
		<h5>Consultar tarefa</h5>
		<br/>
		<table id="consulta-tarefas" class="table table-hover  table-striped table-sm">
			<thead>
				<tr> 
					<th>Nome da tarefa</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Descrição</th>
					<th>Prioridade</th>
					<th>Operações</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tarefas}" var = "item">					
					<tr> 
						<td>${item.nome}</td>				
						<td>${item.data}</td>
						<td>${item.hora}</td>
						<td>${item.descricao}</td>
						<td>
							<c:if test="${item.prioridade == 'ALTA' }">
								<span class="badge bg-danger">Prioridade ALTA</span>
							</c:if>
							<c:if test="${item.prioridade == 'MEDIA' }">
								<span class="badge bg-warning">Prioridade MEDIA</span>
							</c:if>
							<c:if test="${item.prioridade == 'BAIXA' }">
								<span class="badge bg-success">Prioridade BAIXA</span>
							</c:if>														
						</td>
						<td>
							<a href="/projetoSpringMVC01_b/tarefas-edicao?id=${item.idTarefa}" class="btn btn-primary btn-sm">Editar</a>
							<a href="#" class="btn btn-danger btn-sm">Excluir</a>
						</td>
					</tr>
			 	</c:forEach>
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">Quantidade de tarefas: ${tarefas.size()} </td> <!-- o colspan 6 é para acompanhar a quantidade de colunas que ja exisitiam, assim indo de ponta a ponta -->
				</tr>			
			</tfoot>
			
			
		</table>	
	</div>
	

	<!-- adicionando referencia para as bibliotecas de JS (javascript) -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/dataTables.min.js"></script>
	
	<script>
		let table = new DataTable('#consulta-tarefas',{
			language: {url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/Portuguese-Brasil.json'
				}

		});
		
	</script>
	
</body>
</html>


