package com.example.borad1.boardTest01.respository;

import com.example.borad1.boardTest01.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시글의 모든 댓글을 조회하는 메서드
    List<Comment> findByBoardId(Long boardId);

    // 특정 게시글의 댓글 개수를 조회하는 메서드 (JPQL 사용 예시)
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.board.id = :boardId")
    int countByBoardId(@Param("boardId") Long boardId);

    // 특정 게시글의 댓글을 삭제하는 메서드 (JpaRepository에서 제공하는 deleteById()를 사용할 수도 있습니다.)
    void deleteByBoardId(Long boardId);

}
