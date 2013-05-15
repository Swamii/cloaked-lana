package se.akseli.library.test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.akseli.library.controllers.BookController;

public class BookTest extends TestCase {

	@BeforeClass
	public static void init() throws Exception {
		//final Properties p = new Properties();
		//p.put("jdbc/customerDB");
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		final Context ctx = EJBContainer.createEJBContainer().getContext();
		
		BookController bb = (BookController) ctx.lookup("BookBean");
		
		assertNotNull(bb);
	}

}
