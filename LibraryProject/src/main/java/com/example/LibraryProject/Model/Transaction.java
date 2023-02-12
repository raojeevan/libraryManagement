package com.example.LibraryProject.Model;

import com.example.LibraryProject.Enum.Status;
import com.example.LibraryProject.Enum.TxnStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue
  private int id;

  @ManyToOne
  private Student student;

  @Enumerated(value= EnumType.STRING)
  private TxnStatus txnStatus;

  @ManyToOne
  private Book book;

  @CreationTimestamp
  private Date issuedOn;

  private int payment;



}
