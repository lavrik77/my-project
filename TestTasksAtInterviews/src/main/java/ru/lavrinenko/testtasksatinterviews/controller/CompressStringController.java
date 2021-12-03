package ru.lavrinenko.testtasksatinterviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lavrinenko.modeldto.CompressStringDTO;
import ru.lavrinenko.testtasksatinterviews.service.CompressStringService;

@Controller
public class CompressStringController {

  @Autowired
  CompressStringService compressStringService;

  @GetMapping("/compressstring")
  public String startPage(CompressStringDTO compressStringDTO, Model model) {
    model.addAttribute("results", compressStringService.getResults());
    return "compressstring";
  }

  @PostMapping("/compressstring")
  public String results(CompressStringDTO compressStringDTO, Model model) {
    model.addAttribute("results", compressStringService.getResults(compressStringDTO));
    return "compressstring";
  }

  private Model validate(Model model, CompressStringDTO compressStringDTO) {

    return model;
  }

}
