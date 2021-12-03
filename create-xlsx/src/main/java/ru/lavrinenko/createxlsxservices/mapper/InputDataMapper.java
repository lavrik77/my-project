package ru.lavrinenko.createxlsxservices.mapper;

import ru.lavrinenko.createxlsxservices.mapper.modelDTO.InputDataDTO;
import ru.lavrinenko.createxlsxservices.model.InputData;

import java.io.*;
import java.util.ArrayList;

public class InputDataMapper {

  public InputData getInputData(InputDataDTO inputDataDTO) throws IOException {
    InputData inputData = new InputData();

    inputData.setDataBytes(toByteArray(inputDataDTO.getList()));
    return inputData;
  }

  public InputDataDTO getInputDataDTO(InputData inputData) {
    InputDataDTO inputDataDTO = new InputDataDTO();
    inputDataDTO.setList(cast(inputData.getDataBytes()));
    return inputDataDTO;
  }

  /**
   * Сериализовать объект в байтовый массив,
   * если объект null, вернётся пустой массив
   *
   * @param object Форма запроса
   * @return Сериализованный объект
   */
  public byte[] toByteArray(Serializable object) throws IOException {

    if (object == null)
      return new byte[]{};

    ByteArrayOutputStream out = null;
    ObjectOutputStream oos = null;
    try {
      out = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(out);
      oos.writeObject(object);
      oos.flush();
      return out.toByteArray();
    } finally {
      try {
        if (oos != null) oos.close();
        if (out != null) out.close();
      } catch (Exception ignore) {
      }
    }
  }

  /**
   * Десериализовать объект из массива данных,
   * если массив пустой, вернётся null
   *
   * @param data Массив данных
   * @return Десериализованный объект
   */
  public Serializable fromByteArray(byte[] data) {

    if (data == null || data.length == 0) return null;

    try {
      try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
        return (Serializable) ois.readObject();
      }
    } catch (IOException e) {
      throw new RuntimeException("Ошибка при десериализации данных", e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Не найден класс объекта", e);
    }
  }

  /**
   * Десериализация объекта из байтового массива
   * Если аргумент не байтовый массив, он преобразуется к указанному типу
   *
   * @param object Данные для преобразования
   * @param <T>    Тип необходимого объекта
   * @return Десериализованный объект
   */
  @SuppressWarnings("unchecked")
  public <T> ArrayList<T> cast(Serializable object) {

    if (object instanceof byte[]) {
      Serializable s = fromByteArray((byte[]) object);
      return (ArrayList<T>) s;
    }
    return null;
  }
}
