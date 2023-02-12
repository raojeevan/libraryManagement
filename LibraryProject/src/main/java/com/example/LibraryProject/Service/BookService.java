package com.example.LibraryProject.Service;

import com.example.LibraryProject.Enum.BookFilterType;
import com.example.LibraryProject.Enum.Genre;
import com.example.LibraryProject.Enum.Status;
import com.example.LibraryProject.Model.Author;
import com.example.LibraryProject.Model.Book;
import com.example.LibraryProject.Repository.AuthorRepository;
import com.example.LibraryProject.Repository.BookRepository;
import com.example.LibraryProject.Request.BookCreateRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorService authorService;
  public void updateBook(BookCreateRequest bookCreateRequest) {
    Book book = bookCreateRequest.toBook();
    Author author=book.getAuthor();
    Author authorFromDb= authorService.findByEmail(author.getEmail());

    if(authorFromDb==null){
      authorService.save(author);
      authorFromDb=author;
    }
    book.setAuthor(authorFromDb);
    bookRepository.save(book);
  }

  public void addBook(BookCreateRequest bookCreateRequest) {
    Book book = bookCreateRequest.toBook();
    Author author=book.getAuthor();
    Author authorFromDb= authorService.findByEmail(author.getEmail());

    if(authorFromDb==null){
     authorService.save(author);
     authorFromDb=author;
    }
    book.setAuthor(authorFromDb);
    book.setStatus(Status.AVAILABLE);
    bookRepository.save(book);
  }

  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }
  public List<Book> findBooks(BookFilterType bookFilterType, String value) {

    switch (bookFilterType){
      case AUTHOR_NAME:
        return bookRepository.findByAuthor_name(value);

      case BOOK_NAME:
        return bookRepository.findByName(value);

      case GENRE:
        return bookRepository.findByGenre(Genre.valueOf(value));

      case ID:
        return bookRepository.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));

    }
    return null;
  }
}
