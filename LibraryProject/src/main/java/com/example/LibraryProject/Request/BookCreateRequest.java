package com.example.LibraryProject.Request;

import com.example.LibraryProject.Enum.Genre;
import com.example.LibraryProject.Enum.Status;
import com.example.LibraryProject.Model.Author;
import com.example.LibraryProject.Model.Book;
import com.example.LibraryProject.Model.Student;
import com.example.LibraryProject.Model.Transaction;
import java.util.List;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCreateRequest {

  @NotBlank
  private String name;
  @NotNull
  private Author author;
  @NotNull
  private Genre genre;

  public Book toBook(){
    return Book.builder()
        .name(name)
        .author(author)
        .genre(genre)
        .build();
  }
}
