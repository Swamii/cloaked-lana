package se.akseli.library.dto;

import se.akseli.library.entities.Book;

public class BookMapper {
	
	public static Book map(BookDto dto) {
		Book book = new Book();
		book.setBookId(dto.getBookId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		return book;
	}
	
	public static BookDto map(Book book) {
		BookDto dto = new BookDto();
		dto.setBookId(book.getBookId());
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(book.getPrice());
		return dto;
	}
	
}
