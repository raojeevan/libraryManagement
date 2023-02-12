package com.example.LibraryProject.Service;

import com.example.LibraryProject.Model.Author;
import com.example.LibraryProject.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  AuthorRepository authorRepository;
  public void save(Author author) {
    authorRepository.save(author);
  }

  public Author findByEmail(String email) {
   return authorRepository.findByEmail(email);
  }
}
