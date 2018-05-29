<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Pessoas</title>
	
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
			<h2>Alteração de Salário</h2>
			
			<form class="form-horizontal" method="post" action="PessoaServlet" name="form1">
					
				    <div class="form-group">
				      <label class="control-label col-sm-2" for="aumento">Aumento (%): </label>
				      <div class="col-sm-10">
				      	<input type="number" autofocus="autofocus" class="form-control" id="aumento" placeholder="Digite o aumento em %" name="aumento" value="${pessoa.aumento}"  required>
				      </div>
				    </div>
				    
					<div class="form-group">
					    <label class="control-label col-sm-2" for="cargo2">Cargo:</label>
					  	<div class="col-sm-10">
						  	<select class="form-control" id="cargo2" name="cargo" required>
							    <option value="">Selecione o cargo que receberá o aumento</option>
							    <c:forEach var="cargo" items="${listaCargo}">
                                	<option value="${cargo.id}">${cargo.nome}</option>
                            	</c:forEach>
						  	</select>
						  </div>
					</div>
					
					<table class="table table-striped table-condensed table-hover">
						<tr>
							<td>ID</td>
							<td>Nome</td>
							<td>Salário Novo</td>
							<td>Salário Antigo</td>
						</tr>
						<c:forEach var="pessoa" items="${listaPessoas}">
							<tr>
								<td>${pessoa.id}</td>
								<td>${pessoa.nome}</td>
								<td>R$ ${pessoa.salario}</td>
								<td>R$ ${pessoa.salarioAntigo}</td>
							</tr>
						</c:forEach>
					</table>
					
					<INPUT TYPE="hidden" NAME="acao" VALUE="AlterarSalario">
						
					<div class="form-group">
						<button type="reset" class="btn btn-primary">Limpar</button>
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
				</form>
			
			
	 		<br/>
	 		<a href="menuPessoa.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>		
		</div>
	</div>
</div>
</body>
</html>