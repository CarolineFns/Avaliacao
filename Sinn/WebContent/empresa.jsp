<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
	
	<title>Cadastro de Empresa</title>
	
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
				
				<h2>Cadastro de Empresa</h2>
				
				<form class="form-horizontal" method="post" action="EmpresaServlet" name="form1">
					
					<div class="form-group">
				      <label class="control-label col-sm-2" for="nome">Nome:</label>
				      <div class="col-sm-10">
				      	<input type="text" autofocus="autofocus" class="form-control" id="nome" placeholder="Digite o nome" name="nome" value="${empresa.nome}" required>
				      </div>
				    </div>
				    
				    <div class="form-group">
				      <label class="control-label col-sm-2" for="cnpj">CNPJ:</label>
				      <div class="col-sm-10">
				      	<input type="text" autofocus="autofocus" class="form-control" id="cnpj" placeholder="Digite o cnpj" name="cnpj" value="${empresa.cnpj}" 
				      	onKeyPress="mascaraCNPJ(form1.cnpj);" maxlength="18" required>
				      </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="dono">Dono:</label>
					  	<div class="col-sm-10">
						  	<select class="form-control" id="dono" name="dono">
							    <option value="">Selecione o dono</option>
							    <c:forEach var="pessoa" items="${listaPessoa}">
                                	<option value="${pessoa.id}">${pessoa.nome}</option>
                            	</c:forEach>
						  	</select>
						  </div>
					</div>
				    
				    <INPUT TYPE="hidden" NAME="acao" VALUE="Incluir">
					    	 
					<div class="form-group">
						<button type="reset" class="btn btn-primary">Limpar</button>
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
					
				</form>
				
				<a href="menuEmpresa.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
			
			</div>
		</div>
	</div>
</body>
</html>