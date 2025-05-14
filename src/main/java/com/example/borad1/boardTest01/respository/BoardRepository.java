package com.example.borad1.boardTest01.respository;

import com.example.borad1.boardTest01.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    // 필요한 추가적인 메서드를 선언할 수 있습니다.
    // 예: 제목으로 게시글 찾기, 작성자로 게시글 목록 조회 등
    // List<Board> findByTitleContaining(String keyword);
    // List<Board> findByWriter(String writer);
}
