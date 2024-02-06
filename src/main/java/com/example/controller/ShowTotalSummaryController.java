package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TotalSummary;
import com.example.service.ShowTotalSummaryService;

@RequestMapping(path = ShowTotalSummaryController.BASE_URL)
@RestController
public class ShowTotalSummaryController {
                  public static final String BASE_URL = "/detail/{id}";

                  private final ShowTotalSummaryService showTotalSummaryService;

                  @Autowired
                  public ShowTotalSummaryController(ShowTotalSummaryService showTotalSummaryService) {
                                    this.showTotalSummaryService = showTotalSummaryService;
                  }

                  // @PathVariable: URLの一部をメソッドのパラメータとして取得するためのアノテーション
                  @GetMapping(path = "")
                  public TotalSummary getTotalSummary(@PathVariable String id) {
                                    TotalSummary totalSummary = showTotalSummaryService.findTotalSummary(id);
                                    return totalSummary;
                  }

}
