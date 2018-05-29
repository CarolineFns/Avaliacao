<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Cargos</title>
	
	<!-- Main styles for this application -->
	<link href="css/deps.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.0/css/all.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-25369798-12"></script>
	<link rel="shortcut icon" type="image/x-icon" href="img/3572sinnLogo.ico">

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden sidebar-hidden fundo">

	<div class="container">
		
		<jsp:include page="cabecalho.jsp" />
		
		<div class="panel-body">	
			<div align="center">
				
				<h2>Consulta de Cargos</h2>
				
				<table class="table table-striped table-condensed table-hover">
					<tr>
						<td>ID</td>
						<td>Nome</td>
						<td>Excluir</td>
						<td>Editar</td>
					</tr>
					<c:forEach var="cargo" items="${listaCargo}">
						<tr>
							<td>${cargo.id}</td>
							<td>${cargo.nome}</td>
							<td><a class="btn btn-default btn-sm" href="CargoServlet?acao=Excluir&id=${cargo.id}"><i class="fa fa-trash"></i></a></td>
							<td><a class="btn btn-default btn-sm" href="CargoServlet?acao=IrParaTelaAlterar&id=${cargo.id}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>
				</table>
				
				<c:if test="${fn:length(listaCargo) > 0}">
		   		Total de Cargos: ${fn:length(listaCargo)}
		 		
		 		</c:if><br/> 
		 		<a href="menuCargo.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>		
			</div>
		</div>
	</div>
</body>
</html>