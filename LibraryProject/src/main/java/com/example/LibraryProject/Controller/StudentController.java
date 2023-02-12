package com.example.LibraryProject.Controller;

import com.example.LibraryProject.Model.Student;
import com.example.LibraryProject.Request.StudentCreateRequest;
import com.example.LibraryProject.Service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("/addStudent")
  public ResponseEntity addStudent(@RequestBody StudentCreateRequest studentCreateRequest){
    studentService.save(studentCreateRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/updateStudent")
  public ResponseEntity updateStudent(@RequestBody StudentCreateRequest studentCreateRequest){
    studentService.save(studentCreateRequest);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @PatchMapping("/updateStudent")
  public ResponseEntity updateStudentDetails(@RequestBody StudentCreateRequest studentCreateRequest){
    studentService.save(studentCreateRequest);
    return new ResponseEntity<>( HttpStatus.ACCEPTED);
  }

  @GetMapping("/student/{id}")
  public Optional<Student> getStudentByid(@PathVariable("id") int id){
   return studentService.findById(id);
  }

  @GetMapping("/students")
  public List<Student> getAllStudents(){
    return studentService.findAllStudents();
  }

}
