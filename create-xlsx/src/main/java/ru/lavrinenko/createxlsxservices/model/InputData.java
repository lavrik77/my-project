package ru.lavrinenko.createxlsxservices.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class InputData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String email;
  private LocalDateTime date;
  @Lob
  private byte[] dataBytes;

}
