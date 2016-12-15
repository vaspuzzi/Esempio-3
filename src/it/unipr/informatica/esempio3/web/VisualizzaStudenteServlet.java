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
@WebServlet("/visualizza_studente")
public class VisualizzaStudenteServlet extends HttpServlet {
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

			String matricolaStringa = request.getParameter("matricola");

			if(matricolaStringa == null || matricolaStringa.length() == 0)
				throw new IllegalArgumentException("matricola non valido");

			int matricola = Integer.parseInt(matricolaStringa);
			
			Studente studente = modelloStorage.getStudente(matricola);
			
			session.setAttribute("visualizza_studente", studente);
			
			request.getRequestDispatcher("visualizza_studente.jsp").forward(request, response);
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			
			request.getRequestDispatcher("errore.jsp").forward(request, response);			
		}
	}
}
