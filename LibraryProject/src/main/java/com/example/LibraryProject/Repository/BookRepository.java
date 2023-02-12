package com.example.LibraryProject.Repository;

import com.example.LibraryProject.Enum.Genre;
import com.example.LibraryProject.Model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  List<Book> findByAuthor_name(String value);

  List<Book> findByName(String value);

  List<Book> findByGenre(Genre value);

  List<Book> findAllById(int value);
}
