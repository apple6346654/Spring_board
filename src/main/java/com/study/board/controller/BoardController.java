package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 라고 스프링에게 지정해준다.
@Slf4j // 사용법 찾아봐
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm() {

        return "boardwrite";  //화면 띄운다
    }

                   //<form action="/board/writepro" 과 PostMapping의 URL이 동일해야 한다.
    @PostMapping("/board/writepro") //정보 전달
    public String boardWrite(Board board, Model model) {

       boardService.write(board);

       model.addAttribute("message" , "게시글이 작성 되었습니다.");
        model.addAttribute("searchUrl", "/board/list"); // board/list 이쪽 으로 이동


        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list",boardService.boardList() ); //key= 변수 , value= 값  이루어짐

        return "boardlist";
    }


    @GetMapping("/board/view") //localhost:8080/board/view?id=1
    public String bordView(Model model, Integer id){
        model.addAttribute("board",boardService.boardView(id) );

        return "boardview";
    }

    @GetMapping("/board/delete") //localhost:8080/board/delete?id=1
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")    // @PathVariable은 {id}안에 있는 id가 인식이 돼서 Integer 타입의 id로 들어 온다는 뜻
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board){

        Board boardTemp = boardService.boardView(id);//boardbView에서 전에 있던 게시물 내용을 불러오고
        boardTemp.setTitle(board.getTitle()); //boardTemp변수에  setTitle 입력하여 덮어 씌운다
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp); //write로 들어가서 저장

        return "redirect:/board/list";
    }




    }

