<%@page import="it.unipr.informatica.modello.Studente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=ISO-8859-1">
<title>Esempio 3</title>
</head>
<body>
<h1>Sistema di Gestione dell'Ateneo</h1>
<p><a href="index.jsp">Torna alla pagina principale</a></p>
<p><a href="elenco_studenti">Elenco degli studenti</a></p>
<%
	Studente studente = (Studente)session.getAttribute("visualizza_studente");

	session.removeAttribute("visualizza_studente");

	if(studente == null) {
%>
<h2>Studente non trovato</h2>
<%
	} else {
%>
<p>Matricola: <%=studente.getMatricola() %></p>
<p>Cognome: <%=studente.getCognome() %></p>
<p>Nome: <%=studente.getNome() %></p>
<%		
	}
%>
</body>
</html>
