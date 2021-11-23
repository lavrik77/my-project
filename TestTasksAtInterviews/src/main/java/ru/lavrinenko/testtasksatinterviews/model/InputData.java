package ru.lavrinenko.testtasksatinterviews.model;

import javax.persistence.*;

@Entity
public class InputData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long Id;
  private byte[] byteArr;

}
