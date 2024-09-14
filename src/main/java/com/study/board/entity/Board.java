package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //엔티티라고 지정
@Data //쓰면 get으로 읽어줄수 있다? 다시 확인
public class Board {
    
    @Id //pk를 지정하는것
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 이거 뭔지 확인해라 MYsql은 IDNTITY사용 한다
    private Integer id;  //데이터 타입을 래퍼타입?으로만 지정해야함 이거 다시 확인해라

    private String title;

    private String content;
}
