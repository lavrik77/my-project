package ru.lavrinenko.testtasksatinterviews.mapper;

import org.mapstruct.Mapper;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.QuadraticEquationDTO;
import ru.lavrinenko.testtasksatinterviews.model.QuadraticEquation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuadraticEquationMapper {

  QuadraticEquationDTO getResultDTO(QuadraticEquation quadraticEquation);

  List<QuadraticEquationDTO> getResultListDTO(List<QuadraticEquation> quadraticEquations);

  QuadraticEquation getResult(QuadraticEquationDTO quadraticEquationDTO);

  List<QuadraticEquation> getResultList(List<QuadraticEquationDTO> quadraticEquationsDTO);
}
