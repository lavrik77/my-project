package ru.lavrinenko.createxlsxservices.mapper.modelDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
public class InputDataDTO {
  private String name;
  private String email;
  private LocalDateTime date;
  private ArrayList<Object> list;
}
