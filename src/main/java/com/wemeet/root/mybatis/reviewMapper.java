package com.wemeet.root.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.wemeet.root.dto.reviewDTO;

public interface reviewMapper {
	public ArrayList<reviewDTO> reviewHome(@Param("s") int start, @Param("e") int end);
	public int selectReviewCount();
	public int reviewSave(reviewDTO dto);
	public reviewDTO reviewContent(int content_id);
	public void upHit(int content_id);
	public int reviewGetNo(@Param("cust_id") String cust_id, @Param("title") String title, @Param("content") String content);
}
