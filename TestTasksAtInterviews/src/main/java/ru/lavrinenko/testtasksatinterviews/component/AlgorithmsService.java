package ru.lavrinenko.testtasksatinterviews.component;

import ru.lavrinenko.modeldto.CompressStringDTO;
import ru.lavrinenko.modeldto.DeleteDuplicatesDTO;
import ru.lavrinenko.modeldto.QuadraticEquationDTO;

public interface AlgorithmsService {

  DeleteDuplicatesDTO deleteDuplicates(DeleteDuplicatesDTO deleteDuplicatesDTO);

  CompressStringDTO compressString(CompressStringDTO compressStringDTO) throws Exception;

  QuadraticEquationDTO calculate(QuadraticEquationDTO quadraticEquationDTO) throws Exception;

}
