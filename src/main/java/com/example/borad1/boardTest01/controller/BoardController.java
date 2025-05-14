package com.example.borad1.boardTest01.controller;

import com.example.borad1.boardTest01.entity.Board;
import com.example.borad1.boardTest01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(Model model, @PageableDefault(size = 10, sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        Page<Board> boards = boardService.boardList(pageable);
        model.addAttribute("boards",boards);
        return "board/boardList";  // Thymeleaf 템플릿 경로
    }

    // 게시글 작성 폼
    @GetMapping("/write")
    public String boardWriteForm() {
        return "board/boardWriteForm"; // Thymeleaf 템플릿 경로
    }

    // 게시글 작성 처리
    @PostMapping("/write")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "redirect:/board/list";
    }

    // 특정 게시글 조회
    @GetMapping("/view")
    public String boardView(Model model, Long id) {
        Board board = boardService.view(id);
        System.out.println("조회된 Board 객체: " + board); // 로깅 추가
        model.addAttribute("board", board);
        return "board/boardView"; // Thymeleaf 템플릿 경로
    }

    // 게시글 수정 폼
    @GetMapping("/modify")
    public String boardModifyForm(Model model, Long id) {
        Board board = boardService.view(id); // 수정 폼에서도 내용을 보여주기 위해 조회
        model.addAttribute("board", board);
        return "board/boardModifyForm"; // Thymeleaf 템플릿 경로
    }

    // 게시글 수정 처리
    @PostMapping("/modify")
    public String boardModifyPro(Board board) {
        System.out.println("수정 요청 Board 객체: " + board); // 로깅 추가
        boardService.modify(board.getId(), board.getTitle(), board.getContent());
        return "redirect:/board/view?id=" + board.getId();
    }

    // 게시글 삭제 처리
    @GetMapping("/delete")
    public String boardDelete(Long id) {
        boardService.delete(id);
        return "redirect:/board/list";
    }

}
