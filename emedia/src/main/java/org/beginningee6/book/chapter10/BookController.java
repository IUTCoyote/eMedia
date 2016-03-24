package org.beginningee6.book.chapter10;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class BookController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private BookEJB bookEJB;
    private Book book = new Book();
    private Emprunt emprunt;
    private Abonne abonne = new Abonne();
    private List<Book> bookList = new ArrayList<Book>();

    // ======================================
    // =           Public Methods           =
    // ======================================
    
    public String DoInitCreateBook() {
    	return "newBook.xhtml";
    }
    
    public String ReturnAccueil() {
    	return "index.xhtml";
    }
    
    public String DoInitListBook() {
    	bookList = bookEJB.findBooks();
    	return "borrowBooks.xhtml";
    }

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "listBooks.xhtml";
    }
    
    public String doCreateEmprunt(String isbn) {
    	for (Book unbook : bookList) {
			if(unbook.getIsbn() == isbn) {
				book = unbook;
			}
		}
    	abonne = new Abonne();
    	emprunt = new Emprunt(book.getIsbn(), abonne.getIdAbonne());
    	//emprunt = bookEJB.createEmprunt(emprunt);
    	return "RecapEmprunt.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
    	bookList = bookEJB.findBooks();
    	
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
    public Abonne getAbonne() {
    	return abonne;
    }
    
    public Emprunt getEmprunt()
    {
    	return emprunt;
    }
}