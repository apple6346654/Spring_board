package com.study.board.service;


import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board){

        boardRepository.save(board); // db에 저장시키는 명령어

    }

    public List<Board> boardList(){

        return boardRepository.findAll();
    }

    public Board boardView(Integer id){

        return boardRepository.findById(id).get(); //findById는 옵셔널 값으로 가지고온다?? 찾아봐
    }

    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }
}
