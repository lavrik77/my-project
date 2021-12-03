package ru.lavrinenko.testtasksatinterviews.mapper;

import org.mapstruct.Mapper;
import ru.lavrinenko.modeldto.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.model.CompressString;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompressStringMapper {

  CompressStringDTO getCompressStringDTO(CompressString compressString);

  List<CompressStringDTO> getCompressStringListDTO(List<CompressString> compressStrings);

  CompressString getCompressString(CompressStringDTO compressStringDTO);

  List<CompressString> getCompressStringList(List<CompressStringDTO> compressStringsDTO);
}
