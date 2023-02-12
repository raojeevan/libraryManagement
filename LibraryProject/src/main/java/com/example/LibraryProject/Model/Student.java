package com.example.LibraryProject.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
  @Id
  @GeneratedValue
  private int id;

  private String name;

  @Column(unique = true)
  private String email;

  @OneToMany (mappedBy = "student")
  private List<Book> bookList;

  @OneToMany (mappedBy = "student")
  private List<Transaction> transactionList;
}
