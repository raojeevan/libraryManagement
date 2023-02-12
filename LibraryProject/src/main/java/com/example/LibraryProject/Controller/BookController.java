package com.example.LibraryProject.Controller;

import com.example.LibraryProject.Enum.BookFilterType;
import com.example.LibraryProject.Model.Book;
import com.example.LibraryProject.Request.BookCreateRequest;
import com.example.LibraryProject.Service.BookService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  @Autowired
   private BookService bookService;

  @PostMapping("/addBook")
  public ResponseEntity addBook(@RequestBody BookCreateRequest bookCreateRequest){
    bookService.addBook(bookCreateRequest);
    return new ResponseEntity<>( HttpStatus.CREATED);
  }

  @PutMapping("/updateBook")
  public ResponseEntity updateBook(@RequestBody BookCreateRequest bookCreateRequest){
    bookService.updateBook(bookCreateRequest);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @PatchMapping("/updateBook")
  public ResponseEntity updateBookDetails(@RequestBody BookCreateRequest bookCreateRequest){
    bookService.updateBook(bookCreateRequest);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/deleteBook")
  public String deleteBook(@PathVariable("id") int id){
    bookService.deleteBook(id);
    return "Book Deleted Successfully";
  }


  @GetMapping("/books/search")
  public List<Book> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
      @RequestParam("value") String value){
    return bookService.findBooks(bookFilterType, value);
  }



}
