package ru.lavrinenko.testtasksatinterviews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lavrinenko.testtasksatinterviews.component.AlgorithmsServiceImpl;
import ru.lavrinenko.testtasksatinterviews.dao.CompressStringRepository;
import ru.lavrinenko.testtasksatinterviews.mapper.CompressStringMapper;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.CompressStringDTO;

import java.util.List;

@Service
public class CompressStringService {

  private final Logger log = LoggerFactory.getLogger(CompressStringService.class);

  private final CompressStringRepository compressStringRepository;
  private final CompressStringMapper compressStringMapper;
  private final AlgorithmsServiceImpl algorithmsService;

  @Autowired
  public CompressStringService(CompressStringRepository compressStringRepository, CompressStringMapper compressStringMapper, AlgorithmsServiceImpl algorithmsService) {
    this.compressStringRepository = compressStringRepository;
    this.compressStringMapper = compressStringMapper;
    this.algorithmsService = algorithmsService;
  }

  public List<CompressStringDTO> getResults() {
    return compressStringMapper.getCompressStringListDTO(compressStringRepository.findAll());
  }

  public List<CompressStringDTO> getResults(CompressStringDTO compressStringDTO) {
    if (compressStringDTO.getInputStr().isEmpty()) {
      log.error("Входная строка пустая, данные не были сохранены в БД!");
    } else {
      saveResult(compressStringDTO);
    }
    return getResults();
  }

  private void saveResult(CompressStringDTO compressStringDTO){
    try {
      compressStringRepository.save(compressStringMapper.getCompressString(algorithmsService.compressString(compressStringDTO)));
      log.info(compressStringDTO.toString() + ": Запись добавлена в БД.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
