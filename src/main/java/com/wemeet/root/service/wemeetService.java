package com.wemeet.root.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface wemeetService {
	public void reviewHome(Model model, int num);
	public String reviewSave(HttpServletRequest request);
	public void reviewContent(int content_id, Model model);
	public void upHit(int review_no);
}
