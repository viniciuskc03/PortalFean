<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Pagina do Professor</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adiciona um Professor
</h1>

<c:url var="addAction" value="/professores/add" ></c:url>

<form:form action="${addAction}" commandName="professor">
<table>
	<c:if test="${!empty professor.nome}">
	<tr>
		<td>
			<form:label path="matricula">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="matricula" readonly="true" size="8"  disabled="true" />
			<form:hidden path="matricula" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="dataNascimento">
				<spring:message text="Data de Nascimento"/>
			</form:label>
		</td>
		<td>
			<form:input path="dataNascimento" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="cpf">
				<spring:message text="Cpf"/>
			</form:label>
		</td>
		<td>
			<form:input path="cpf" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="rg">
				<spring:message text="Rg"/>
			</form:label>
		</td>
		<td>
			<form:input path="rg" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty professor.nome}">
				<input type="submit"
					value="<spring:message text="Editar Professor"/>" />
			</c:if>
			<c:if test="${empty professor.nome}">
				<input type="submit"
					value="<spring:message text="Adicionar Professor"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Professores</h3>
<c:if test="${!empty listarProfessores}">
	<table class="tg">
	<tr>
		<th width="80">Matricula</th>
		<th width="120">Nome</th>
		<th width="120">Data Nascimento</th>
		<th width="120">Cpf</th>
		<th width="120">Rg</th>
		<th width="60">Editar</th>
		<th width="60">Deletar</th>
	</tr>
	<c:forEach items="${listarProfessores}" var="professor">
		<tr>
			<td>${professor.matricula}</td>
			<td>${professor.nome}</td>
			<td>${professor.dataNascimento}</td>
			<td>${professor.cpf}</td>
			<td>${professor.rg}</td>
			<td><a href="<c:url value='/editar/${professor.matricula}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${professor.matricula}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
