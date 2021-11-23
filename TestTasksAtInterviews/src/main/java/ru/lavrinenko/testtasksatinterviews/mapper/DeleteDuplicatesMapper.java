package ru.lavrinenko.testtasksatinterviews.mapper;

import org.mapstruct.Mapper;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.mapper.modelDTO.DeleteDuplicatesDTO;
import ru.lavrinenko.testtasksatinterviews.model.CompressString;
import ru.lavrinenko.testtasksatinterviews.model.DeleteDuplicates;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeleteDuplicatesMapper {

  DeleteDuplicatesDTO getDeleteDuplicatesDTO(DeleteDuplicates deleteDuplicates);

  List<DeleteDuplicatesDTO> getDeleteDuplicatesListDTO(List<DeleteDuplicates> deleteDuplicates);

  DeleteDuplicates getDeleteDuplicates(DeleteDuplicatesDTO deleteDuplicatesDTO);

  List<DeleteDuplicates> getDeleteDuplicatesList(List<DeleteDuplicatesDTO> deleteDuplicatesDTOS);
}
