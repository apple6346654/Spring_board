package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                               //Entity이름,그 엔티티의 ID의 데이터 타입 입력
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
