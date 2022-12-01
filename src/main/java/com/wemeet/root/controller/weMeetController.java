package com.wemeet.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wemeet.root.service.wemeetService;
import com.wemeet.root.service.wemeetServiceImplement;

@RequestMapping("wwmReview")
@Controller
public class weMeetController {
	@Autowired wemeetService ms;
	
	@GetMapping("reviewHome")
	public String weMeetHome(Model model,
			@RequestParam(required = false, defaultValue = "1") int num) {
		ms.reviewHome(model, num);
		
		return "wwmReview/reviewHome";
	}
	
	@GetMapping("reviewContent")
	public String weMeetContent(@RequestParam("content_id") int content_id, Model model, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ms.reviewContent(content_id, model);
		
		return "wwmReview/reviewContent";
	}
	
	@GetMapping("reviewWrite")
	public String reviewWrite() {
		return "wwmReview/reviewWrite";
	}
	
	@PostMapping("reviewSave")
	public void reviewSave(MultipartHttpServletRequest mul,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String message = ms.reviewSave(mul, request);
		PrintWriter out = null;
		response.setContentType("text/html; charset=utf-8");
		out = response.getWriter();
		out.println(message);		
	}
	
	
	
	
}
