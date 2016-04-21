package fr.demos.cineromev2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.cineromev2.data.CineRomeV2DAO;
import fr.demos.cineromev2.data.FileCineRomeV2DAO;
import fr.demos.cineromev2.data.SqlCineRomeV2DAO;
import fr.demos.cineromev2.metier.ArticleCineRomeV2;
import fr.demos.cineromev2.metier.PanierCineRomeV2;

/**
 * Servlet implementation class ListDesArticles
 */
@WebServlet("/ListDesArticles")
public class ListDesArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDesArticles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/listeArticle.jsp");
		List<ArticleCineRomeV2> listArticles = null;
		CineRomeV2DAO articleDao = new FileCineRomeV2DAO();

		try {
			listArticles = articleDao.rechercheTout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listArticles", listArticles);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		boolean erreur = false;
		String addItem = request.getParameter("addItem");
		String rmItem = request.getParameter("rmItem");
		String reference = request.getParameter("reference");
		ArticleCineRomeV2 article;

		if (addItem != null && addItem.equals("addItem")) {
			String Qty = request.getParameter("Qty");
			request.setAttribute("Qte", Qty);

			int Qte = 0;

			try {
				Qte = Integer.parseInt(Qty);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("QtyErreur", "erreur de saissie");

			}
			if (!erreur) {
				// System.out.println(Qte);
				// RequestDispatcher rd =
				// request.getRequestDispatcher("/PanierCineRomeV2Controller");
				// rd.forward(request, response);

				try {
					// CineRomeV2DAO dao2 = new SqlCineRomeV2DAO();
					// dao.sauvePanier(newAddItem);
					CineRomeV2DAO dao = new SqlCineRomeV2DAO();
					article = dao.rechercheArticle(reference);
					HttpSession session = request.getSession();
					PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");
					panier.ajouterArticle(article, Qte);
					RequestDispatcher rd = request.getRequestDispatcher("/PanierCineRomeV2Controller");
					rd.forward(request, response);
					System.out.println("sauveSQL panier");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		if (rmItem != null && rmItem.equals("rmItem")) {
			String Qtys = request.getParameter("Qty");
			request.setAttribute("Qte", Qtys);

			int Qtes = 0;
			try {
				Qtes = Integer.parseInt(Qtys);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("QtyErreur", "erreur de saissie");

			}
			if (!erreur) {

				// RequestDispatcher rd =
				// request.getRequestDispatcher("/PanierCineRomeV2Controller");
				// rd.forward(request, response);
				try {
					// CineRomeV2DAO dao2 = new SqlCineRomeV2DAO();
					// dao.sauvePanier(newAddItem);
					CineRomeV2DAO dao = new SqlCineRomeV2DAO();
					article = dao.rechercheArticle(reference);
					HttpSession session = request.getSession();
					PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");
					panier.retirerArticle(article, Qtes);
					RequestDispatcher rd = request.getRequestDispatcher("/PanierCineRomeV2Controller");
					rd.forward(request, response);
					System.out.println("RMSQL panier");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}

// doGet(request, response);
// RequestDispatcher rd =
// request.getRequestDispatcher("/listClimatisation.jsp");
// rd.forward(request, response);
