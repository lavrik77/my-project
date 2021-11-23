package ru.lavrinenko.testtasksatinterviews.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.DeleteDuplicatesDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.QuadraticEquationDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AlgorithmsServiceTest {

  @Autowired
  private AlgorithmsService algorithmsService;

  private QuadraticEquationDTO getQuadraticEquationDTO(double a, double b, double c) {
    QuadraticEquationDTO quadraticEquationDTO = new QuadraticEquationDTO();
    quadraticEquationDTO.setParamA(a);
    quadraticEquationDTO.setParamB(b);
    quadraticEquationDTO.setParamC(c);
    return quadraticEquationDTO;
  }

  private CompressStringDTO getCompressStringDTO(String str) {
    CompressStringDTO compressStringDTO = new CompressStringDTO();
    compressStringDTO.setInputStr(str);
    return compressStringDTO;
  }

  private DeleteDuplicatesDTO getDeleteDuplicatesDTO(String str) {
    DeleteDuplicatesDTO deleteDuplicatesDTO = new DeleteDuplicatesDTO();
    deleteDuplicatesDTO.setInputStr(str);
    return deleteDuplicatesDTO;
  }

  @Test
  void deleteDuplicates() {

  }

  @Test
  void compressString() {

  }

  @Test
  void calculate() {
    try {
      assertEquals("x1= 1.0, x2= -4.0", algorithmsService.calculate(getQuadraticEquationDTO(1, 3, -4)).getResult());
      assertEquals("x= 2.0", algorithmsService.calculate(getQuadraticEquationDTO(1, -4, 4)).getResult());
      assertEquals("Нет решений!", algorithmsService.calculate(getQuadraticEquationDTO(1, -5, 9)).getResult());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Exception exception = assertThrows(Exception.class, () -> algorithmsService.calculate(getQuadraticEquationDTO(0,1,1)));
    assertEquals("Коэффициент а = 0. Решение уравнения невозможно!!!", exception.getMessage());
  }
}