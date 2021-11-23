package ru.lavrinenko.testtasksatinterviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompressString {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String inputStr;
  private String resultStr;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getInputStr() {
    return inputStr;
  }

  public void setInputStr(String inputStr) {
    this.inputStr = inputStr;
  }

  public String getResultStr() {
    return resultStr;
  }

  public void setResultStr(String resultStr) {
    this.resultStr = resultStr;
  }
}
