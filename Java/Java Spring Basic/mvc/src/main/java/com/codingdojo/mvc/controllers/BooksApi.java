package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@RestController
public class BooksApi {
	private BookService bookService;
	public void Books(BookService bookService){
		this.bookService = bookService;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") int id) {
		Book book = bookService.findBookByIndex(id);
		return book;
	}
}
