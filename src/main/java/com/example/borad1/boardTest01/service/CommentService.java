package com.example.borad1.boardTest01.service;

import com.example.borad1.boardTest01.entity.Board;
import com.example.borad1.boardTest01.respository.BoardRepository;
import com.example.borad1.boardTest01.respository.CommentRepository;
import com.example.borad1.boardTest01.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 작성
    public void write(Long boardId, String writer, String content) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        Comment comment = new Comment();
        comment.setBoard(board);
        comment.setWriter(writer);
        comment.setContent(content);
        commentRepository.save(comment);
    }
    // 특정 게시글의 댓글 목록 조회
    public List<Comment> commentList(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    // 댓글 삭제
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    // 특정 게시글의 모든 댓글 삭제 (게시글 삭제 시 사용)
    @Transactional
    public void deleteAllCommentsByBoardId(Long boardId) {
        commentRepository.deleteByBoardId(boardId);
    }

}
