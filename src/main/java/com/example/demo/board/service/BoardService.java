package com.example.demo.board.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.board.vo.Board;
import com.example.demo.board.mapper.BoardMapper;

@Service
public class BoardService {
    @Autowired BoardMapper mBoardMapper;
    
    public List<Board> boardListService() {
        return mBoardMapper.boardList(); //리스트를 return
    }
    
    public Board boardDetailService(int bno) {
        
        return mBoardMapper.boardDetail(bno);
    }
    
    public int boardInsertService(Board board) {
        
        return mBoardMapper.boardInsert(board);
    }
    
    public String boardUpdateService(Board board) {
    	int success = mBoardMapper.boardUpdate(board);
    	
    	if(success> 0)
    		return "수정이 완료되었습니다.";
    	else
    		return "수정에 실패하였습니다.";
    }
    
    public String boardDeleteService(int bno) {
        int success = mBoardMapper.boardDelete(bno);
        
    	if(success> 0)
    		return "삭제가 완료되었습니다.";
    	else
    		return "삭제에 실패하였습니다.";
    }
}