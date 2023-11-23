package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = HomeController.BASE_URL)
@RestController
public class HomeController {

                  public static final String BASE_URL = "/home";

                  @GetMapping(path = "")
                  public void home() {
                                    System.out.println("hello java");
                                    System.out.println("hello java");
                                    System.out.println("hello java");
                                    System.out.println("hello java");
                  }
}