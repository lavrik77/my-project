package ru.lavrinenko.testtasksatinterviews.mapper.modelDTO;

public class QuadraticEquationDTO {

  private Double paramA;
  private Double paramB;
  private Double paramC;
  private String result;

  public Double getParamA() {
    return paramA;
  }

  public void setParamA(Double paramA) {
    this.paramA = paramA;
  }

  public Double getParamB() {
    return paramB;
  }

  public void setParamB(Double paramB) {
    this.paramB = paramB;
  }

  public Double getParamC() {
    return paramC;
  }

  public void setParamC(Double paramC) {
    this.paramC = paramC;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Коэффициенты уравнения: a=").append(getParamA())
                        .append(", b=").append(getParamB())
                        .append(", c=").append(getParamC());
        str.append("; Результат вычислений: ").append(getResult());
        return str.toString();
      }
}
