package com.wemeet.root.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface wemeetFileService {
	public static final String IMAGE_REPO	= "E:/WhereWeMeetFile";
	
	public String getMessage(HttpServletRequest request, String msg, String url);
//	public void transferFile(MultipartHttpServletRequest mul);
	public void transferFile(MultipartFile file, String fileName);
	public String saveOriginFile(MultipartFile file);
	public void deleteFile(String originFileName);
}
