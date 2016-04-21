package fr.demos.cineromev2.metier;

public class BluRayCineRomeV2 extends ArticleCineRomeV2 {

	String r�alisateur;
	String titre;
	String auteur;
	String editeur;
	String genre;
	
	
	public BluRayCineRomeV2(double prixHt, int stock, String designation, String reference, String director, String titre, String auteur, String editeur, String genre) {
		super(prixHt, stock, designation, reference);
		this.r�alisateur = director;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.genre = genre;
	}


	public String getR�alisateur() {
		return r�alisateur;
	}


	public void setR�alisateur(String r�alisateur) {
		this.r�alisateur = r�alisateur;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "BluRayCineRome [r�alisateur=" + r�alisateur + ", titre=" + titre + ", auteur=" + auteur + ", editeur="
				+ editeur + ", genre=" + genre + ", getR�alisateur()=" + getR�alisateur() + ", getTitre()=" + getTitre()
				+ ", getAuteur()=" + getAuteur() + ", getEditeur()=" + getEditeur() + ", getGenre()=" + getGenre()
				+ ", getPrixHt()=" + getPrixHt() + ", getStock()=" + getStock() + ", getDesignation()="
				+ getDesignation() + ", getReference()=" + getReference() + "]";
	}
	
}