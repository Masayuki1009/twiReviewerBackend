package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;

@Service
public class GetTwittererCommentService {
                  // コンストラインインジェクション。final指定で変更不可
                  private final CommentRepository commentRepository;

                  @Autowired
                  public GetTwittererCommentService(CommentRepository commentRepository) {
                                    this.commentRepository = commentRepository;
                  }

                  public List<Comment> getTwitterCommentList(String twittererId) {
                                    Integer id = Integer.parseInt(twittererId);
                                    return this.commentRepository.getTwitterCommentList(id);
                  }
}
