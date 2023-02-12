package com.example.LibraryProject.Service;

import com.example.LibraryProject.Model.Student;
import com.example.LibraryProject.Repository.StudentRepository;
import com.example.LibraryProject.Request.StudentCreateRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;
  public void save(StudentCreateRequest studentCreateRequest) {
   Student student = studentCreateRequest.toStudent();
    studentRepository.save(student);
  }

  public Optional<Student> findById(int id) {
    return studentRepository.findById(id);
  }

  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }
}
