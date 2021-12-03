package ru.lavrinenko.modeldto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QuadraticEquationDTO implements Serializable {

  private Double paramA;
  private Double paramB;
  private Double paramC;
  private String result;

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Коэффициенты уравнения: a=").append(paramA)
            .append(", b=").append(paramB)
            .append(", c=").append(paramC);
    str.append("; Результат вычислений: ").append(result);
    return str.toString();
  }
}
