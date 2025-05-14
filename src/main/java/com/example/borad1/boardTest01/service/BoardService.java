package com.example.borad1.boardTest01.service;

import com.example.borad1.boardTest01.entity.Board;
import com.example.borad1.boardTest01.respository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 작성
    public Long write(Board board){
        boardRepository.save(board);
        return board.getId();
    }

    // 게시글 수정
    @Transactional
    public Board view(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        board.setViewCount(board.getViewCount() + 1);
        return board;
    }

    // 게시글 수정
    public void modify(Long id, String title, String content) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        board.setTitle(title);
        board.setContent(content);
        boardRepository.save(board);
    }


    //게시글 삭제
    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    public Page<Board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    // 특정 게시글 검색 (제목, 내용 포함) - 필요에 따라 구현
    // public Page<Board> search(String keyword, Pageable pageable) {
    //     return boardRepository.findByTitleContainingOrContentContaining(keyword, keyword, pageable);
    // }

}
