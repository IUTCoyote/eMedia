package org.beginningee6.book.chapter10;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BookEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter10PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Book> findBooks() {   	
    	List<Book> booksList = em.createNamedQuery("findAllBooks").getResultList();	
    	return booksList; 
    }

    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }
    
    public Emprunt createEmprunt(Emprunt emprunt) {
    	em.persist(emprunt);
    	return emprunt;
    }
}