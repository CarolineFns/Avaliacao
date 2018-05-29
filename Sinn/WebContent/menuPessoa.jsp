<!DOCTYPE html>
<html lang="pt-br">

<head>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="SSDA">
	<link rel="shortcut icon" href="img/favicon.png">

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
				<h2>Cadastro de Pessoa</h2>
				<br>
				<a href="index.jsp" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
				<a href="PessoaServlet?acao=IrParaTelaInsercao" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Cadastrar</a>
				<a href="PessoaServlet?acao=Listar" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i> Consultar</a>
				<a href="PessoaServlet?acao=IrParaTelaAlterarSalario" class="btn btn-primary"><i class="fa fa-money" aria-hidden="true"></i> Alterar Salários</a>
			</div>
		</div>
	</div>
	
</body>

</html>