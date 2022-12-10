package com.wemeet.root.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class wemeetFileServiceImplement implements wemeetFileService{

	@Override
	public String getMessage(HttpServletRequest request, String msg, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferFile(MultipartFile file, String fileName) {
		System.out.println("transferFile 내부");
		File transferToFile = new File(IMAGE_REPO + "/" + fileName);
		try {
			file.transferTo(transferToFile);//해당 위치에 파일 저장
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String saveOriginFile(MultipartFile file) {
		String originalFileName = file.getOriginalFilename();
		return originalFileName;
	}

	@Override
	public void deleteFile(String originFileName) {
		// TODO Auto-generated method stub
		
	}
	
}
