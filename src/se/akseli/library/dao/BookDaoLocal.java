package se.akseli.library.dao;

import java.util.List;

import javax.ejb.Local;

import se.akseli.library.dto.BookDto;

@Local
public interface BookDaoLocal {
	
	public BookDto find(Integer id);
	public void addBook(BookDto book);
	public void deleteBook(BookDto book);
	public void deleteBook(Integer id);
	public void updateBook(BookDto book);
	public List<BookDto> getBooks();
	
}
