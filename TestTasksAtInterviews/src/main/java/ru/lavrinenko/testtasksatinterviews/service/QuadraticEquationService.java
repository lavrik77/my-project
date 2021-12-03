package ru.lavrinenko.testtasksatinterviews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lavrinenko.testtasksatinterviews.component.AlgorithmsServiceImpl;
import ru.lavrinenko.testtasksatinterviews.dao.QuadraticEquationRepository;
import ru.lavrinenko.testtasksatinterviews.mapper.QuadraticEquationMapper;
import ru.lavrinenko.modeldto.QuadraticEquationDTO;

import java.util.List;

@Service
public class QuadraticEquationService {

  private final Logger log = LoggerFactory.getLogger(QuadraticEquationService.class);

  private final QuadraticEquationRepository quadraticEquationRepository;
  private final AlgorithmsServiceImpl algorithmsService;
  private final QuadraticEquationMapper quadraticEquationMapper;

  @Autowired
  public QuadraticEquationService(QuadraticEquationRepository quadraticEquationRepository, AlgorithmsServiceImpl algorithmsService, QuadraticEquationMapper quadraticEquationMapper) {
    this.quadraticEquationRepository = quadraticEquationRepository;
    this.algorithmsService = algorithmsService;
    this.quadraticEquationMapper = quadraticEquationMapper;
  }

  public List<QuadraticEquationDTO> getResults() {
    return quadraticEquationMapper.getResultListDTO(quadraticEquationRepository.findAll());
  }

  public List<QuadraticEquationDTO> getResults(QuadraticEquationDTO QuadraticEquationDTO) {
    saveResult(QuadraticEquationDTO);
    return getResults();
  }

  private void saveResult(QuadraticEquationDTO quadraticEquationDTO) {
    try {
      quadraticEquationRepository.save(quadraticEquationMapper.getResult(algorithmsService.calculate(quadraticEquationDTO)));
      log.info(quadraticEquationDTO.toString() + " сохранены в БД.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
