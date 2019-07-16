package com.example.demo.board.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
 
import com.example.demo.board.vo.Board;

@Mapper
public interface BoardMapper {
    public int boardCount();
    public List<Board> boardList();
    
    public Board boardDetail(int bno);
    
    public int boardInsert(Board board);
    public int boardUpdate(Board board);
    public int boardDelete(int bno);
}