<%@page import="it.unipr.informatica.modello.Studente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=ISO-8859-1">
<title>Esempio 3</title>
<script>
function conferma(matricola) {
	var risposta = confirm("Sei sicuro di voler cancellare lo studente " + matricola);

	if(risposta)
		location.href = "cancella_studente?matricola=" + matricola;	
}
</script>
</head>
<body>
<h1>Sistema di Gestione dell'Ateneo</h1>
<p><a href="index.jsp">Torna alla pagina principale</a></p>
<p><a href="elenco_studenti">Elenco degli studenti</a></p>
<p><a href="nuovo_studente.jsp">Nuovo studente</a></p>
<table>
<thead>
<tr>
<td/><td/><td/><td>Matricola</td><td>Cognome</td><td>Nome</td>
</tr>
</thead>
<tbody>
<%
	@SuppressWarnings("unchecked")
	List<Studente> studenti = (List<Studente>)session.getAttribute("elenco_studenti");

	if(studenti != null) {
		for(Studente studente : studenti) {
%>
<tr>
<td><a href="visualizza_studente?matricola=<%=studente.getMatricola() %>">Visualizza</a></td>
<td><a href="modifica_studente?matricola=<%=studente.getMatricola() %>">Modifica</a></td>
<td><a href="javascript:conferma('<%=studente.getMatricola() %>')">Cancella</a></td>
<td><%=studente.getMatricola() %></td>
<td><%=studente.getCognome() %></td>
<td><%=studente.getNome() %></td>
</tr>
<% 
		}
		
		session.removeAttribute("elenco_studenti");
	}	
%>
</tbody>
</table>
</body>
</html>
