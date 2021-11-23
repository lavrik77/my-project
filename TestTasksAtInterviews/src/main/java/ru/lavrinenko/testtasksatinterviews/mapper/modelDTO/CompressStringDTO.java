package ru.lavrinenko.testtasksatinterviews.mapper.modelDTO;

public class CompressStringDTO {
  private String inputStr;
  private String resultStr;

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

  @Override
  public String toString () {
    return getInputStr() + "->" + getResultStr();
  }

}
