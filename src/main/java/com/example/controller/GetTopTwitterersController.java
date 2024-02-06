package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PopularTwitterer;
import com.example.service.GetTopTwitterersService;

@RequestMapping(path = GetTopTwitterersController.BASE_URL)
@RestController
public class GetTopTwitterersController {
                  public static final String BASE_URL = "/home";

                  private final GetTopTwitterersService twittererService;

                  @Autowired
                  public GetTopTwitterersController(GetTopTwitterersService twittererService) {
                                    this.twittererService = twittererService;
                  }

                  @GetMapping(path = "")
                  public List<PopularTwitterer> getTopTwitterers() {
                                    return twittererService.getTopTwitterers();
                  }
}
