package se.akseli.library.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.akseli.library.dto.BookDto;
import se.akseli.library.dto.BookMapper;
import se.akseli.library.entities.Book;

/**
 * Session Bean implementation class BookBean
 */

@LocalBean
@Stateless
public class BookDao implements BookDaoLocal {

	@PersistenceContext(unitName="Library")
	private EntityManager em;
	
	@Override
	public BookDto find(Integer id) {
		return BookMapper.map(em.find(Book.class, id));
	}

	@Override
	public void addBook(BookDto dto) {
		em.persist(BookMapper.map(dto));
	}

	@Override
	public void deleteBook(BookDto dto) {
		em.remove(BookMapper.map(dto));
	}
	
	public void deleteBook(Book book) {
		em.remove(book);
	}

	@Override
	public void deleteBook(Integer id) {
		Book book = em.find(Book.class, id);
		deleteBook(book);
	}

	@Override
	public void updateBook(BookDto dto) {
		em.merge(BookMapper.map(dto));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDto> getBooks() {
		List<BookDto> dtos = new ArrayList<BookDto>();
		List<Book> books = em.createQuery("select b from Book b").getResultList();
		for (Book book : books) {
			dtos.add(BookMapper.map(book));
		}
		return dtos;
	}

}
