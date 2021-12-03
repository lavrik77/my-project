package ru.lavrinenko.testtasksatinterviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String startPage(Model model) {
    return "index";
  }


}
