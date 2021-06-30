package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
 // adding the book repository as a dependency
private final BookRepository bookRepository;
private final Book book;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
     this.book = new Book();
 }
 
 private List<Book> books = new ArrayList<Book>(Arrays.asList(
         new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
         new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
         new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
         new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
         new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
         ));
 
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBookByIndex(int index) {
     if (index < books.size()){
         return books.get(index);
     }else{
         return null;
     }
 }
 public void updateBook(int id, Book book) {
     if (id < books.size()){
         books.set(id, book);
     }
 }
 public void destroyBook(int id) {
     if (id < books.size()){
         books.remove(id);
     }
 }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		if (id < books.size()){
	        book.setId(id);
	        book.setTitle(title);
	        book.setDescription(desc);
	        book.setLanguage(lang);
	        book.setNumberOfPages(numOfPages);
		}
		return bookRepository.save(book);
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	public void addBook(Book book) {
        books.add(book);
	}
}
