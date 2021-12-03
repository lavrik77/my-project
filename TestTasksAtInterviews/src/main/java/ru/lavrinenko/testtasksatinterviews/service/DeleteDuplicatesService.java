package ru.lavrinenko.testtasksatinterviews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lavrinenko.testtasksatinterviews.component.AlgorithmsServiceImpl;
import ru.lavrinenko.testtasksatinterviews.dao.DeleteDuplicatesRepository;
import ru.lavrinenko.testtasksatinterviews.mapper.DeleteDuplicatesMapper;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.DeleteDuplicatesDTO;

import java.util.List;

@Service
public class DeleteDuplicatesService {

  private final Logger log = LoggerFactory.getLogger(DeleteDuplicatesService.class);

  private final DeleteDuplicatesRepository deleteDuplicatesRepository;
  private final AlgorithmsServiceImpl algorithmsService;
  private final DeleteDuplicatesMapper deleteDuplicatesMapper;

  @Autowired
  public DeleteDuplicatesService(DeleteDuplicatesRepository deleteDuplicatesRepository, AlgorithmsServiceImpl algorithmsService, DeleteDuplicatesMapper deleteDuplicatesMapper) {
    this.deleteDuplicatesRepository = deleteDuplicatesRepository;
    this.algorithmsService = algorithmsService;
    this.deleteDuplicatesMapper = deleteDuplicatesMapper;
  }

  public List<DeleteDuplicatesDTO> getResults() {
    return deleteDuplicatesMapper.getDeleteDuplicatesListDTO(deleteDuplicatesRepository.findAll());
  }

  public List<DeleteDuplicatesDTO> getResults(DeleteDuplicatesDTO deleteDuplicatesDTO) {
    if (deleteDuplicatesDTO.getInputStr().isEmpty()) {
      log.error("Входная строка пустая, данные не были сохранены в БД!");
    } else {
      saveResult(deleteDuplicatesDTO);
    }
    return getResults();
  }

  private void saveResult(DeleteDuplicatesDTO deleteDuplicatesDTO) {
    deleteDuplicatesRepository.save(deleteDuplicatesMapper.getDeleteDuplicates(algorithmsService.deleteDuplicates(deleteDuplicatesDTO)));
    log.info(deleteDuplicatesDTO.toString() + ": Запись добавлена в БД.");
  }

}
