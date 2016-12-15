package it.unipr.informatica.esempio3.web;

import javax.servlet.http.HttpSession;

import it.unipr.informatica.modello.ModelloException;
import it.unipr.informatica.modello.ModelloFacade;
import it.unipr.informatica.modello.ModelloStorage;

public class Sessione {
	protected ModelloFacade modelloFacade;
	
	public static Sessione crea(HttpSession session) {
		try {
			Sessione sessione = (Sessione)session.getAttribute("sessione");
			
			if(sessione == null) {
				sessione = new Sessione();
				
				session.setAttribute("sessione", sessione);
			}

			return sessione;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			
			return null;
		}
	}
	
	protected Sessione() throws ModelloException {
		modelloFacade = ModelloFacade.crea("configurazione");
	}
	
	public ModelloStorage getModelloStorage() {
		return modelloFacade.getModelloStorage();
	}
}
