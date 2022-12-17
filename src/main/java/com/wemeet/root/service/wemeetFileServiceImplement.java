package com.wemeet.root.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

@Primary
@Service
public class wemeetFileServiceImplement implements wemeetFileService{

	@Override
	public String getMessage(HttpServletRequest request, String msg, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferFile(MultipartFile file, String fileName) {
		System.out.println("transferFile 내부");
		//File fileName = new File();
		File transferToFile = new File(IMAGE_REPO + "/" + fileName);
		//System.out.println(mul.getFile());
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

	@Override
	public String uploadSummernoteImageFile(MultipartFile file, HttpServletRequest request) {
		JsonObject jsonObject = new JsonObject();
		
//		String fileRoot = IMAGE_REPO;
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getContextPath();
		String fileRoot = contextRoot+"/resources/fileupload";
		
		String originalFileName = file.getOriginalFilename();	//오리지날 파일명
//		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		
		
		File targetFile = new File(fileRoot + originalFileName);	
		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", fileRoot+"/"+originalFileName); // contextroot + resources + 저장할 내부 폴더명
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
	
	
}
