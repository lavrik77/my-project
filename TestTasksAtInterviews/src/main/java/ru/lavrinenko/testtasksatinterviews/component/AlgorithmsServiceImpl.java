package ru.lavrinenko.testtasksatinterviews.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.DeleteDuplicatesDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.QuadraticEquationDTO;

import java.util.stream.Stream;

@Component
public class AlgorithmsServiceImpl implements AlgorithmsService {

  @Value("${validCharacters}")
  String validCharactersForCompressString;

  public DeleteDuplicatesDTO deleteDuplicates(DeleteDuplicatesDTO deleteDuplicatesDTO) {
    int[] arr = Stream.of(deleteDuplicatesDTO.getInputStr().split(","))
            .mapToInt(s-> Integer.parseInt(s.trim()))
            .sorted().toArray();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      if (i == (arr.length - 1) || arr[i] != arr[i + 1]) {
        output.append(" ").append(arr[i]).append(",");
      }
    }

    deleteDuplicatesDTO.setResultStr(output.deleteCharAt(output.length() - 1).toString().trim());
    return deleteDuplicatesDTO;
  }

  public CompressStringDTO compressString(CompressStringDTO compressStringDTO) throws Exception {
    String input = compressStringDTO.getInputStr();
    StringBuilder output = new StringBuilder();
    int count = 1;
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (validCharactersForCompressString.indexOf(ch) == -1)
        throw new Exception("Строка содержит недопустимые символы!");
      if (i == input.length() - 1 || ch != input.charAt(i + 1)) {
        output.append(count > 1 ? ch + String.valueOf(count) : ch);
        count = 0;
      }
      count++;
    }
    compressStringDTO.setResultStr(output.toString());
    return compressStringDTO;
  }

  public QuadraticEquationDTO calculate(QuadraticEquationDTO quadraticEquationDTO) throws Exception {
    double a = quadraticEquationDTO.getParamA();
    if (a == 0) {
      throw new Exception("Коэффициент а = 0. Решение уравнения невозможно!!!");
    }
    double b = quadraticEquationDTO.getParamB();
    double c = quadraticEquationDTO.getParamC();

    double d = b * b - 4 * a * c;
    if (d < 0) {
      quadraticEquationDTO.setResult("Нет решений!");
    } else if (d == 0) {
      quadraticEquationDTO.setResult("x= " + ((-b) / (2 * a)));
    } else {
      quadraticEquationDTO.setResult("x1= " + ((-b + Math.sqrt(d)) / (2 * a)) +
              ", x2= " + ((-b - Math.sqrt(d)) / (2 * a)));
    }
    return quadraticEquationDTO;
  }
}
