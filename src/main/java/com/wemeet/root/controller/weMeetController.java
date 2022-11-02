package com.wemeet.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wemeet.root.service.wemeetService;
import com.wemeet.root.service.wemeetServiceImplement;

@RequestMapping("wwmReview")
@Controller
public class weMeetController {
	@Autowired wemeetService ms;
	
	@GetMapping("reviewHome")
	public String weMeetHome() {
		return "wwmReview/reviewHome";
	}
	
	
	
	
}
