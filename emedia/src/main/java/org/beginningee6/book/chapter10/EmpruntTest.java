package org.beginningee6.book.chapter10;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpruntTest {
	
    // ====================================== //
    // =             Attributes             = //
    // ====================================== //
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    private Abonne abonne;
    
    // ====================================== //
    // =          Lifecycle Methods         = //
    // ====================================== //
	@Before
    public void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("chapter02PU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        abonne = new Abonne();
    }

    @After
    public void closeEntityManager() throws SQLException {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    // ====================================== //
    // =              Unit tests            = //
    // ====================================== //
    @Test
    public void shouldCreateALoan() throws Exception {
        // Creates an instance of book
       	Emprunt emprunt = new Emprunt("10L", abonne.getIdAbonne());
       	
        // Persistence of the loan to the database
        tx.begin();
        em.persist(emprunt);
        tx.commit();
        
        assertNotNull("ID should not be null", emprunt.getIdEmprunt());
        Query query = em.createNamedQuery("findEmprunt");
        
        // Retrieves all the loan from the database
        List<Book> emprunts = query.setParameter("id", "10L").getResultList();
        assertEquals(1, emprunts.size());
    }

}
