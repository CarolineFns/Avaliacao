<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
	<title>Cadastro de Pessoa</title>
	<!-- Main styles for this application -->
	
	<link href="css/deps.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.0/css/all.css" rel="stylesheet">
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-25369798-12"></script>
	<link rel="shortcut icon" type="image/x-icon" href="img/3572sinnLogo.ico">
	<script type="text/javascript" src="js/mascaraValidacao.js"></script>

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden sidebar-hidden fundo">

	<div class="container">
		<div align="center">
			<jsp:include page="cabecalho.jsp" />
			<div class="panel-body">
				<h2>Cadastro de Pessoa</h2>
				<form class="form-horizontal" method="post" action="PessoaServlet" name="form1">
					<div class="form-group">
				      <label class="control-label col-sm-2" for="nome">Nome:</label>
				      <div class="col-sm-10">
				      	<input type="text" autofocus="autofocus" class="form-control" id="nome" placeholder="Digite o nome" name="nome" value="${pessoa.nome}" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-sm-2" for="cpf">CPF:</label>
				      <div class="col-sm-10">
				      	<input type="text" autofocus="autofocus" class="form-control" id="cpf" placeholder="Digite o cpf" name="cpf" value="${pessoa.cpf}" 
				      	onKeyPress="mascaraCPF(form1.cpf);" onkeydown="mascaraCPF(form1.cpf);" maxlength="14" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="control-label col-sm-2" for="salario">Salário:</label>
				      <div class="col-sm-10">
				      	<input type="number" autofocus="autofocus" class="form-control" id="salario" placeholder="Digite o salário" name="salario" value="${pessoa.salario}" required>
				      </div>
				    </div>

					<div class="form-group">
					    <label class="control-label col-sm-2" for="cargo2">Cargo:</label>
					  	<div class="col-sm-10">
						  	<select class="form-control" id="cargo2" name="cargo" required>
							    <option value="">Selecione o cargo</option>
							    <c:forEach var="cargo" items="${listaCargo}">
                                	<option value="${cargo.id}" ${cargo.id eq pessoa.cargo.id ? "SELECTED" : ""}>${cargo.nome}</option>
                            	</c:forEach>
						  	</select>
						  </div>
					</div>
					
						<INPUT TYPE="hidden" NAME="acao" VALUE="Alterar">
						<INPUT TYPE="hidden" NAME="id" VALUE="${pessoa.id}">
						
					<div class="form-group">
						<button type="reset" class="btn btn-primary">Limpar</button>
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
				</form>
				<a href="menuPessoa.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
				
				</div>
			</div>
		</div>
</body>
</html>