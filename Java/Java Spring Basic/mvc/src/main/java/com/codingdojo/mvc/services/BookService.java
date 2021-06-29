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
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
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
}

