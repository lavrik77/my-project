package ru.lavrinenko.testtasksatinterviews.mapper.modelDTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DeleteDuplicatesDTO implements Serializable {

  private String inputStr;
  private String resultStr;

  @Override
  public String toString() {
    return inputStr + " -> " + resultStr;
  }

}
