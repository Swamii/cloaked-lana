package se.akseli.library.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import se.akseli.library.dao.BookDao;
import se.akseli.library.dto.BookDto;

@Named
@SessionScoped
public class BookController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private BookDao dao;
	@Inject
	private BookDto newBook;
	private BookDto selectedBook = new BookDto();
	private DataModel<BookDto> bookModel;
	
	@PostConstruct
	public void init() {
		bookModel = getBookModel();
	}
	
	public void create() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.addBook(newBook);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"The book was successfully added to the database", 
					"")
					);
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error: something went terribly wrong", 
					"")
			);
		}
	}
	
	public DataModel<BookDto> getBookModel() {
		bookModel = new ListDataModel<BookDto>(dao.getBooks());
		return bookModel;
	}
	
	public void update() {
		dao.updateBook(selectedBook);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"The book was updated successfully",
				"")
		);
	}
	
	public void delete() {
		dao.deleteBook(selectedBook.getBookId());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"The book was deleted successfully",
				"")
		);
	}

	public BookDto getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(BookDto selectedBook) {
		this.selectedBook = selectedBook;
	}
	
}
