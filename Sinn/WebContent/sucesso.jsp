<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
	<title>Página de Sucesso</title>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden sidebar-hidden fundo">
	<H1>Mensagem JSTL:	<c:out value="${mensagem}" /></H1>	
	<jsp:include page="empresaLista.jsp"/>	
</body>
</html>