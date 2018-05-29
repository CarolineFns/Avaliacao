<!DOCTYPE html>
<html lang="pt">
<head>
	
	<title>Cadastro de Cargo</title>
	
	<!-- Main styles for this application -->
	<link href="css/deps.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link href="https://use.fontawesome.com/releases/v5.0.0/css/all.css" rel="stylesheet">
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-25369798-12"></script>
	<link rel="shortcut icon" type="image/x-icon" href="img/3572sinnLogo.ico">

</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden sidebar-hidden fundo">

	<div class="container">
		<div align="center">
			
			<jsp:include page="cabecalho.jsp" />
			
			<div class="panel-body">
				
				<h2>Cadastro de Cargo</h2>
				
				<form class="form-horizontal" method="post" action="CargoServlet">
					
					<div class="form-group">
				      <label class="control-label col-sm-2" for="nome">Nome:</label>
				      <div class="col-sm-10">
				      	<input type="text" autofocus="autofocus" class="form-control" id="nome" placeholder="Digite o nome" name="nome" required value="${cargo.nome}">
				      </div>
				    </div>
					    	 
					<div class="form-group">
						<button type="reset" class="btn btn-primary">Limpar</button>
						<button type="submit" class="btn btn-success">Salvar</button>
					</div>
					
					<INPUT TYPE="hidden" NAME="acao" VALUE="Incluir">

				</form>
				
				<a href="menuCargo.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
			
			</div>
		</div>
	</div>
</body>
</html>