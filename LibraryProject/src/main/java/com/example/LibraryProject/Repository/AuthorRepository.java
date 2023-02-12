package com.example.LibraryProject.Repository;

import com.example.LibraryProject.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

  Author findByEmail(String email);
}
