package com.example.LibraryProject.Repository;

import com.example.LibraryProject.Enum.TxnStatus;
import com.example.LibraryProject.Model.Book;
import com.example.LibraryProject.Model.Student;
import com.example.LibraryProject.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction,Integer> {

  Transaction findTopbyBookAndStudentAndTxnStatusOrderByIdDesc(Book book, Student student, TxnStatus issue);
}
