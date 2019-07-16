package com.example.demo.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.vo.Board;
import com.example.demo.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService mBoardService;
    
    @RequestMapping("/list")
    private String boardList(Model model) {
    	model.addAttribute("list", mBoardService.boardListService());

        return "/board/list";
    }
    
    @RequestMapping("/insert")
    private String boardInsertForm(){
        return "/board/insert";
    }
    @RequestMapping("/insertProc")
    private String boardInsertProc(HttpServletRequest request) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String writer = authentication.getName();
		
    	Board board = new Board();
        board.setSubject(request.getParameter("subject"));
        board.setContent(request.getParameter("content"));
        board.setWriter(writer);
        
        mBoardService.boardInsertService(board);
        
        return "redirect:/list";
    }
    
    @RequestMapping("/delete/{bno}")
    @ResponseBody
    private String boardDelete(@PathVariable int bno) {
        String msg = mBoardService.boardDeleteService(bno);
        
        return msg;
    }

    @RequestMapping("/detail/{bno}") 
    private String boardDetail(@PathVariable int bno, Model model) {
        model.addAttribute("detail", mBoardService.boardDetailService(bno));
        
        return "/board/detail";
    }
    @RequestMapping("/update/{bno}")
    @ResponseBody
    private String boardUpdateProc(@PathVariable int bno, HttpServletRequest request) {
    	Board board = new Board();
        board.setSubject(request.getParameter("subject"));
        board.setContent(request.getParameter("content"));
        board.setBno(bno);
        
        String msg = mBoardService.boardUpdateService(board);
        
        return msg;
    }
}