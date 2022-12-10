package com.wemeet.root.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	@Autowired wemeetFileService wfs;
	
	public static final String imageinfo = "E:/filefolder";
	
	
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
		int fileNoCheck = 0;
		ArrayList<String> fileList = new ArrayList<String>();
		ArrayList<Integer> resultFileSave = new ArrayList<Integer>();
		LocalDateTime now = LocalDateTime.now();
		String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		
		
		reviewDTO dto = new reviewDTO();
		dto.setCust_id(mul.getParameter("cust_id"));
		dto.setTitle(mul.getParameter("title"));
		dto.setContent("summernote 사용중");
		System.out.println("content : " + mul.getParameter("content"));
		resultSave = rm.reviewSave(dto);
		
//		System.out.println(mul.getfile);
		System.out.println(mul.getFileNames());
		ArrayList<String> fileName = new ArrayList<String>();
		ArrayList<MultipartFile> valuevalue = new ArrayList<MultipartFile>();
		
//		for(int j = 1; j <= mul.getFileMap().size(); j++) {
//			
//			valuevalue.add(mul.getFileMap().get("file" + j));
//		}
		fileName.addAll(mul.getFileMap().keySet());
		System.out.println("fileName : " + fileName);
		System.out.println("value : " + valuevalue);
		System.out.println("valuesize : " + valuevalue.size());
		
//		for(int k = 0; k < valuevalue.size(); k++) {
//			valuevalue.get(k);
//			
//		}
		
		
//		while(mul.getFileNames().hasNext()) {
//			fileList.add(mul.getFileNames().next());
//			fileCnt++;
//			break;
//		}
		
		fileNoCheck = rm.reviewGetNo(dto.getCust_id(), dto.getTitle(), dto.getContent());
		
		System.out.println("fileNoCheck : " + fileNoCheck);
		System.out.println("fileList : " + fileList);
		System.out.println("fileCnt : " + fileCnt);
		//MultipartFile file = mul.getFile(imageinfo);
		
		for(int i=0;i<fileName.size();i++) {
			
			reviewPhotoDTO photo_dto = new reviewPhotoDTO();
			String fileId = fileNoCheck + dto.getCust_id();
			
			MultipartFile file = mul.getFile(fileName.get(i));
			System.out.println(file);
			if(file != null && file.getSize() != 0 && fileNoCheck != 0) {
				photo_dto.setFileId(fileId + i);
				photo_dto.setFileRealName(file.getOriginalFilename());
				photo_dto.setFileWriter(dto.getCust_id());
				photo_dto.setFileNo(fileNoCheck);
				photo_dto.setInptDate(formatNow);
				System.out.println(photo_dto.getFileId());
				wfs.transferFile(file, photo_dto.getFileId() + file.getOriginalFilename());
				resultFileSave.add(i, rm.fileSave(photo_dto));
			}else {
				resultFileSave.add(i, 1);
			}
		}
		
		
		String msg, url;
		if(resultFileSave.contains(0)) {
			resultPhotoSave = 0;
		}
		
		if(resultSave == 1 && resultPhotoSave == 1) {
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
