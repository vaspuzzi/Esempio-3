package it.unipr.informatica.esempio3.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unipr.informatica.modello.ModelloStorage;
import it.unipr.informatica.modello.Studente;

@SuppressWarnings("serial")
@WebServlet("/elenco_studenti")
public class ElencoStudentiServlet extends HttpServlet {
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

			List<Studente> studenti = modelloStorage.getStudenti();
			
			session.setAttribute("elenco_studenti", studenti);
			
			request.getRequestDispatcher("elenco_studenti.jsp").forward(request, response);
		} catch(Throwable throwable) {
			throwable.printStackTrace();
			
			request.getRequestDispatcher("errore.jsp").forward(request, response);			
		}
	}
}
