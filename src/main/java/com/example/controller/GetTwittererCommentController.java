package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Comment;
import com.example.service.GetTwittererCommentService;

@RequestMapping(path = GetTwittererCommentController.BASE_URL)
@RestController
public class GetTwittererCommentController {
                  public static final String BASE_URL = "/detail/comment/{id}";

                  private final GetTwittererCommentService getTwittererCommentService;

                  @Autowired
                  public GetTwittererCommentController(GetTwittererCommentService getTwittererCommentService) {
                                    this.getTwittererCommentService = getTwittererCommentService;
                  }

                  // 特定のツイッタラーのコメントを取得する
                  @GetMapping(path = "")
                  public List<Comment> getTwitterCommentList(@PathVariable String id) {
                                    return this.getTwittererCommentService.getTwitterCommentList(id);
                  }
}
