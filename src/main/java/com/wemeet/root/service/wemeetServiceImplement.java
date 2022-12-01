package com.wemeet.root.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wemeet.root.dto.reviewDTO;
import com.wemeet.root.dto.reviewPhotoDTO;
import com.wemeet.root.mybatis.reviewMapper;

@Primary
@Service
public class wemeetServiceImplement implements wemeetService {
	@Autowired reviewMapper rm; 
	
	public void reviewHome(Model model, int num) {
		int pageLetter = 5;
		int dataCount = rm.selectReviewCount();
		int repeat = dataCount/pageLetter;
		if(dataCount%pageLetter != 0) {
			repeat += 1;
		}
		int end = dataCount - ((num-1) * 5);
		int start = end + 1 - pageLetter;
		
		int pagingNum = 5;
		int beginPage = 0;
		int endPage = 0;
		
		int pagingCount = (num - 1)/pagingNum;
		beginPage = pagingCount * pagingNum + 1;
		endPage = beginPage + 4;
		
		if(repeat < endPage) {
			endPage = repeat;
		}
		System.out.println(dataCount);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("beginPage", beginPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("repeat", repeat);
		model.addAttribute("reviewList", rm.reviewHome(start, end));
	}

	@Override
	public String reviewSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		int resultSave = 0;
		int resultPhotoSave = 1;
		int fileCnt = 0;
		ArrayList<String> fileList = new ArrayList<String>();
		
		reviewDTO dto = new reviewDTO();
		dto.setCust_id(mul.getParameter("cust_id"));
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		resultSave = rm.reviewSave(dto);
		
		while(mul.getFileNames().hasNext()) {
			fileList.add(fileCnt, mul.getFileNames().next());
			fileCnt++;
		}
		
		for(int i=0;i<fileCnt;i++) {
			reviewPhotoDTO photo_dto = new reviewPhotoDTO();

			MultipartFile file = mul.getFile(fileList.get(fileCnt));
			
			
		}
		
		
		String msg, url;
		if(resultSave == 1) {
			msg = "리뷰등록 완료";
			url = "/wwmReview/reviewHome";
		}else {
			msg = "리뷰등록 완료";
			url = "/wwmReview/reviewWrite";
		}	
		String message = null;
		String path = request.getContextPath();
		message = "<script>alert('" + msg + "');";
		message += "location.href='" + path + url + "';</script>";
		return message;
	}

	@Override
	public void reviewContent(int content_id, Model model) {
		upHit(content_id);
		model.addAttribute("reviewContent", rm.reviewContent(content_id));
	}
	
   public void upHit(int review_no) {
	   rm.upHit(review_no);
   }
	
}
