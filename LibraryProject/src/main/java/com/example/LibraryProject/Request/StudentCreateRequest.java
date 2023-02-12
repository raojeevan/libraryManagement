package com.example.LibraryProject.Request;

import com.example.LibraryProject.Model.Student;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentCreateRequest {


  @NotBlank
  private String name;
  @NotNull
  private String email;

  public Student toStudent()
  {
    return Student.builder()
                  .name(name)
                  .email(email)
                  .build();
  }

}
