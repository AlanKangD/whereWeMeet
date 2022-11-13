package com.wemeet.root.dto;

import org.springframework.stereotype.Component;

@Component
public class reviewDTO {
	private int content_id;
	private String cust_id;
	private String title;
	private String content;
	private String inpt_date;
	private int view_cnt;
	
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInpt_date() {
		return inpt_date;
	}
	public void setInpt_date(String inpt_date) {
		this.inpt_date = inpt_date;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	 
}
