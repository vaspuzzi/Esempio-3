package it.unipr.informatica.esempio3.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unipr.informatica.modello.ModelloStorage;
import it.unipr.informatica.modello.Studente;

@SuppressWarnings("serial")
@WebServlet("/nuovo_studente")
public class NuovoStudenteServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			
			Sessione sessione = Sessione.crea(session);

			ModelloStorage modelloStorage = sessione.getModelloStorage();

			String cognome = request.getParameter("cognome");

			String nome = request.getParameter("nome");
			
			if(cognome == null || cognome.length() == 0)
				throw new IllegalArgumentException("cognome non valido");

			if(nome == null || nome.length() == 0)
				throw new IllegalArgumentException("nome non valido");

			Studente studente = modelloStorage.aggiungiStudente(cognome, nome);
			
			session.setAttribute("visualizza_studente", studente);
			
			request.getRequestDispatcher("visualizza_studente.jsp").forward(request, response);
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			
			request.getRequestDispatcher("errore.jsp").forward(request, response);			
		}
	}
}
