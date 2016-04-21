package fr.demos.cineromev2.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.cineromev2.metier.ArticleCineRomeV2;
import fr.demos.cineromev2.metier.PanierCineRomeV2;


public class FileCineRomeV2DAO implements CineRomeV2DAO {

	@Override
	public void sauve(ArticleCineRomeV2 Ar) throws Exception {
		ArrayList<ArticleCineRomeV2> liste = new ArrayList<>();
		// lecture fichier avant �criture : on r�cup�re la liste des clims (si
		// elle existe)
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("article-version")));) {
			liste = (ArrayList) ois.readObject();
		} catch (IOException exc) {
			System.out.println(exc.getMessage());
		} catch (ClassNotFoundException exc) {
			System.out.println(exc.getMessage());
		}
		// on complete la liste retrouv�e avec le nouvel �l�ment

		liste.add(Ar);
		// on �crit la nouvelle liste
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("article-version")));) {
			oos.writeObject(liste);
			oos.flush();
			
//			System.out.println(liste);
		}

	}

	@Override
	public List<ArticleCineRomeV2> rechercheTout() throws Exception {
		ArrayList<ArticleCineRomeV2> liste = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("article-version")));) {

			liste = (ArrayList<ArticleCineRomeV2>) ois.readObject();

		} catch (EOFException exc) {
			System.out.println("fin de fichier");

		} catch (IOException exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
		} catch (ClassNotFoundException exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
		}
		return liste;

	}

	@Override
	public List<ArticleCineRomeV2> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere) {
		// TODO Auto-generated method stub
		List<ArticleCineRomeV2> liste = null;
		int nb = 0;
		try {
			liste = this.rechercheTout();
			nb = liste.size();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return nb;
	}

//	@Override
//	public void sauvePanier(PanierCineRomeV2 Pa) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeItemCart(PanierCineRomeV2 Pa) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public ArticleCineRomeV2 rechercheArticle(String reference) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStock(int stock) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStock(ArticleCineRomeV2 article, int stock) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCart(PanierCineRomeV2 Panier) throws Exception {
		// TODO Auto-generated method stub
		
	}

}