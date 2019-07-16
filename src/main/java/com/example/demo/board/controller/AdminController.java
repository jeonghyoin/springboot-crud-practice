package com.example.demo.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.board.service.AdminService;

@Controller
public class AdminController {
	@Autowired AdminService adminService;
    
    @RequestMapping("/admin/setting")
    private String redirectToAdmin() {
        return "/admin/setting";
    }
    
    @RequestMapping("/access")
    private String accessDenied() {
        return "/resources/access";
    }
    
	@RequestMapping(value="/admin/progress", method=RequestMethod.POST)
	public String progressBar(HttpServletRequest request)  {
		String username = request.getParameter("username");
		int range = Integer.valueOf(request.getParameter("hiddenRange"));
		
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("username", username);
	    parameters.put("range", range);
	    
		adminService.updateProgress(parameters);
		
		return "redirect:/admin/setting";
	}
	@RequestMapping(value="/admin/users")
	public String showUserList(Model model)  {
		model.addAttribute("list", adminService.showUserList());
		
		return "/admin/users";
	}
}