package com.example.borad1.boardTest01.controller;

import com.example.borad1.boardTest01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성 처리
    @PostMapping("/comment/write")
    public String commentWrite(@RequestParam("boardId") Long boardId,
                               @RequestParam("writer") String writer,
                               @RequestParam("content") String content) {
        commentService.write(boardId, writer, content);
        return "redirect:/board/view?id=" + boardId;
    }

    // 댓글 삭제 처리
    @GetMapping("/comment/delete")
    public String commentDelete(@RequestParam("id") Long commentId, @RequestParam("boardId") Long boardId) {
        commentService.delete(commentId);
        return "redirect:/board/view?id=" + boardId;
    }

}
