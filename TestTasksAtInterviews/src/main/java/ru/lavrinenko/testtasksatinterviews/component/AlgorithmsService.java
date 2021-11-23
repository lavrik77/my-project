package ru.lavrinenko.testtasksatinterviews.component;

import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.DeleteDuplicatesDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.QuadraticEquationDTO;

public interface AlgorithmsService {

  DeleteDuplicatesDTO deleteDuplicates(DeleteDuplicatesDTO deleteDuplicatesDTO);

  CompressStringDTO compressString(CompressStringDTO compressStringDTO) throws Exception;

  QuadraticEquationDTO calculate(QuadraticEquationDTO quadraticEquationDTO) throws Exception;

}
