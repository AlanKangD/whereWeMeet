package com.wemeet.root.mybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.wemeet.root.dto.reviewDTO;
import com.wemeet.root.dto.reviewPhotoDTO;

public interface reviewMapper {
	public ArrayList<reviewDTO> reviewHome(@Param("s") int start, @Param("e") int end);
	public int selectReviewCount();
	public reviewDTO reviewContent(int content_id);
	public void upHit(int content_id);
	
	//게시글작성
	public int reviewSave(reviewDTO dto);
	public int reviewGetNo(@Param("cust_id") String cust_id, @Param("title") String title, @Param("content") String content);
	
	//파일저장
	public int fileSave(reviewPhotoDTO fileDTO);
	public int fileModify(reviewPhotoDTO fileDTO);
	public int fileDelete(reviewPhotoDTO fileDTO);
}
