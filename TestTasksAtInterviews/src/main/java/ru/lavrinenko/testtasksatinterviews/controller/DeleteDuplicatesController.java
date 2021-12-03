package ru.lavrinenko.testtasksatinterviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lavrinenko.modeldto.DeleteDuplicatesDTO;
import ru.lavrinenko.testtasksatinterviews.service.DeleteDuplicatesService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeleteDuplicatesController {

  @Autowired
  DeleteDuplicatesService deleteDuplicatesService;

  @GetMapping("/deleteduplicates")
  public String startPage(DeleteDuplicatesDTO deleteDuplicatesDTO, Model model) {
    model.addAttribute("results", deleteDuplicatesService.getResults());
    return "deleteduplicates";
  }

  @PostMapping("/deleteduplicates")
  public String results(DeleteDuplicatesDTO deleteDuplicatesDTO, Model model) {
    model.addAttribute("results", deleteDuplicatesService.getResults(deleteDuplicatesDTO));
    return "deleteduplicates";
  }

  private void validate(DeleteDuplicatesDTO deleteDuplicatesDTO, Model model) {
    List<String> errors = new ArrayList();
  }

}
