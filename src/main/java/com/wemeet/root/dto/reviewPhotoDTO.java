package com.wemeet.root.dto;

public class reviewPhotoDTO {
	private String fileId;
	private String fileRealName;
	private String inptDate;
	private String fileWriter;
	private int fileNo;
	
	
	public String getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(String fileWriter) {
		this.fileWriter = fileWriter;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public String getInptDate() {
		return inptDate;
	}
	public void setInptDate(String inptDate) {
		this.inptDate = inptDate;
	}
}
