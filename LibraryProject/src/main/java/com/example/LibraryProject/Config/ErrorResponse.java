package com.example.LibraryProject.Config;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

  private List<String> message;
  private HttpStatus status;
  private String devMessage;
  private String ApplErrorCode;
}
