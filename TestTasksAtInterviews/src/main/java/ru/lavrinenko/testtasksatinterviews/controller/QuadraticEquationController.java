package ru.lavrinenko.testtasksatinterviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lavrinenko.modeldto.QuadraticEquationDTO;
import ru.lavrinenko.testtasksatinterviews.service.QuadraticEquationService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuadraticEquationController {

  @Autowired
  QuadraticEquationService quadraticEquationService;

  @GetMapping("/quadraticequation")
  public String startPage(QuadraticEquationDTO quadraticEquationDTO, Model model) {
    model.addAttribute("results", quadraticEquationService.getResults());
    return "quadraticequation";
  }

  @PostMapping("/quadraticequation")
  public String results(QuadraticEquationDTO quadraticEquationDTO, Model model) {

    if (quadraticEquationDTO.getParamA() == null || quadraticEquationDTO.getParamA() == 0) {
      List<String> errorsList = new ArrayList<>();
      errorsList.add("Коэффициент А не может быть null или равен 0!");
      model.addAttribute("errors", errorsList);
      return "quadraticequation";
    }
    model.addAttribute("results", quadraticEquationService.getResults(quadraticEquationDTO));
    return "quadraticequation";
  }
}
