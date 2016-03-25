package org.beginningee6.book.chapter10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "findEmprunt", query = "SELECT e FROM Emprunt e WHERE e.idBook = :id")
public class Emprunt {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private int idEmprunt;
    @OneToOne (fetch=FetchType.LAZY)
    @JoinColumn (nullable=false)
    private Integer idAbonne;
    @OneToOne (fetch=FetchType.LAZY)
    @JoinColumn (nullable=false)
    private String idBook;
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;
    @Temporal(TemporalType.DATE)
    private Date dateRetour;


    // ======================================
    // =            Constructors            =
    // ======================================
    public Emprunt() {
    	this.dateEmprunt = new Date();
		Calendar calendrier = Calendar.getInstance();
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
		calendrier.add(Calendar.DATE, 30);	
		String date = parser.format(calendrier.getTime());
		try {
			this.setDateRetour(parser.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

   	public Emprunt(String idBook, Integer idAbonne) {
   		this();
		this.idAbonne = idAbonne;
		this.idBook = idBook;
		this.idEmprunt = 1;
   	}
   	
	// ======================================
    // =          Getters & Setters         =
    // ======================================
	public int getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Integer getIdAbonne() {
		return idAbonne;
	}

	public void setIdAbonne(Integer idAbonne) {
		this.idAbonne = idAbonne;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Emprunt");
        sb.append("{idEmprunt=").append(idEmprunt);
        sb.append(", idAbonne='").append(idAbonne).append('\'');
        sb.append(", idBook=").append(idBook);
        sb.append(", dateEmprunt=").append(dateEmprunt);
        sb.append(", dateRetour=").append(dateRetour);
        sb.append('}');
        return sb.toString();
    }


}