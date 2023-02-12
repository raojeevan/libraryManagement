package com.example.LibraryProject.Model;

import com.example.LibraryProject.Enum.Genre;
import com.example.LibraryProject.Enum.Status;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  @ManyToOne
  private Author author;

  @ManyToOne
  @JoinColumn
  private Student student;

  @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
  private List<Transaction> transactionList;

  @Enumerated(value= EnumType.STRING)
  private Genre genre;

  @Enumerated(value= EnumType.STRING)
  private Status status;

  @CreationTimestamp
  private Date createdOn;

  @UpdateTimestamp
  private Date updatedOn;

}
