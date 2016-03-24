package org.beginningee6.book.chapter10;

public class Abonne {

    //private static volatile Abonne instance = null;
    private Integer idAbonne;
    private String email;
    private String pass;
    private String pseudo;

    /**
     * Constructeur de l'objet.
     */
    public Abonne() { 
    	this.idAbonne = 1;
    	this.email = "edc@gmail.com";
    	this.pass = "edc";
    	this.pseudo = "edc123";
    }

    public String getEmail() {
		return email;
	}
    
	public String getPass() {
		return pass;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public Integer getIdAbonne() {
		return idAbonne;
	}
	
}
