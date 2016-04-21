package fr.demos.cineromev2.metier;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.cineromev2.data.CineRomeV2DAO;
import fr.demos.cineromev2.data.SqlCineRomeV2DAO;


public class PanierCineRomeV2 {
	
	private ArrayList<ArticleCineRomeV2> listPanier;

	public PanierCineRomeV2() {
		
		listPanier = new ArrayList<ArticleCineRomeV2>();
	}

	public void ajouterArticle(ArticleCineRomeV2 article, int qte) throws PanierCineRomeV2Exception, Exception {
		if (article.existe()) {
			this.listPanier.add(article);
			CineRomeV2DAO sqlAddDao =  new SqlCineRomeV2DAO();
			sqlAddDao.updateStock(article, -qte);
			
		} else
			throw new PanierCineRomeV2Exception("Il n'y a plus d'article en stock");
	}

	public void retirerArticle(ArticleCineRomeV2 article, int qte) throws PanierCineRomeV2Exception, Exception {
//		HttpSession session = request.getSession();
//		PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");
		if (!listPanier.isEmpty()) {// pour tester son panier vide il y a la
										// fonction listePanier.isemptu.
			this.listPanier.remove(article);
			// article.incrementer(qte);
			CineRomeV2DAO sqlRmDao = new SqlCineRomeV2DAO();
			sqlRmDao.updateStock(article, qte);
		} else
			throw new PanierCineRomeV2Exception("Il n'y a rien dans le panier");
	}

	public ArrayList<ArticleCineRomeV2> getListePanier() {
		return listPanier;
	}

	public void setListePanier(ArrayList<ArticleCineRomeV2> listePanier) {
		this.listPanier = listePanier;
	}

	@Override
	public String toString() {
		return "Panier [listePanier=" + listPanier + "]";
	}

}