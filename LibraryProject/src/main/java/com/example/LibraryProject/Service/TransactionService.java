package com.example.LibraryProject.Service;

import com.example.LibraryProject.Config.BookNotAvailableException;
import com.example.LibraryProject.Enum.Status;
import com.example.LibraryProject.Enum.TxnStatus;
import com.example.LibraryProject.Model.Book;
import com.example.LibraryProject.Model.Student;
import com.example.LibraryProject.Model.Transaction;
import com.example.LibraryProject.Repository.BookRepository;
import com.example.LibraryProject.Repository.StudentRepository;
import com.example.LibraryProject.Repository.TransactionRepository;
import java.util.concurrent.TimeUnit;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Builder
@Service
public class TransactionService {
  @Autowired
  TransactionRepository transactionRepository;
  @Autowired
  BookRepository bookRepository;
  @Autowired
  StudentRepository studentRepository;
  public void issueTxn(int studentId, int bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow(
        ()->new BookNotAvailableException("Book with given id not available"));
    if(book.getStatus() == Status.AVAILABLE)
    {
     book.setStatus(Status.ISSUED);
     Student student= studentRepository.findById(studentId).orElseThrow(
         ()->new RuntimeException("Student with Id not available"));
      book.setStudent(student);
      bookRepository.save(book);

      Transaction transaction= new Transaction();
      transaction=Transaction.builder().txnStatus(TxnStatus.ISSUE).book(book).student(student).build();
      transactionRepository.save(transaction);
    }
    else throw new BookNotAvailableException("Book Already Issued");
  }

  public void returnTxn(int studentId, int bookId) {
    Book book = bookRepository.findById(bookId).orElseThrow(
        ()->new BookNotAvailableException("Book with given id not available"));
    if(book.getStatus() == Status.ISSUED) {
      Student student = book.getStudent();
      if (student.getId() == studentId) {
        book.setStatus(Status.AVAILABLE);
        book.setStudent(null);
        bookRepository.save(book);

        Transaction issueTxn = transactionRepository.findTopbyBookAndStudentAndTxnStatusOrderByIdDesc(book,student,TxnStatus.ISSUE);
        Long issueDate = issueTxn.getIssuedOn().getTime();

        Long diff=System.currentTimeMillis()-issueDate;
        Long totalDays= TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        int payment= 0;
        if(totalDays>30.0) {
          payment= (int) ((totalDays-30) *5);
        }

        Transaction transaction= new Transaction();
        transaction=Transaction.builder().txnStatus(TxnStatus.RETURN).book(book).student(student).payment(payment).build();
        transactionRepository.save(transaction);
      } else throw new RuntimeException("Book is not issued to this student");
    }
    else throw new BookNotAvailableException("Book is already returned");
  }
}
