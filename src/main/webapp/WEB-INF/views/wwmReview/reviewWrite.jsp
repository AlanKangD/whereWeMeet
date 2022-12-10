<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="reviewSave" value="${contextPath }/wwmReview/reviewSave"/>
    <c:set var="reviewHome" value="${contextPath }/wwmReview/reviewHome"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var fileCnt = 1;
	
	function add_file(){/* 사진을 추가할 수 있는 새로운 input과 비어있는 preview를 생성하는 기능 */
/* 		if(photo_count == 10){
			alter("사진은 최대 10장까지 첨부할 수 있습니다.")
		}else{
 			var str_photo = "<p id='p_"+photo_num+"'><input type='file' name='review_file_name_"+(photo_num)+"' "
				+ "id='review_file_name_"+(photo_num)+"' onchange='load_preview(review_file_name_"+(photo_num)+", preview_"+photo_num+"); '/>"
				+ "<a href='#p_"+photo_num+"' onClick='delete_photo(p_"+photo_num+");' class='btn'>삭제하기</a></p>"
			var str_preview = "<p id='p_"+photo_num+"' style='margin:2px;'><img id='preview_"+ photo_num +"' "
				+ "style='align:right;' alt='이미지가 없습니다.' src='#'  width='320' height='180'></p>"
			$("#photo_div").append(str_photo);
			$("#preview_div").append(str_preview);
			photo_num++;
			photo_count++;
			$("#photo_count").val(photo_count);
			$("#fileList").append("안녕하세요");
		} */
		$("#fileList").append("<p class='file"+fileCnt+"'><input type='checkbox' name='filename' value='file"+fileCnt+"'><input type='file' name='file"+fileCnt+"'/></p>");
		fileCnt++;
		
	}
	
	function delete_file(){
		var fileList = document.getElementsByName("filename");
		var delList = [];
		console.log(fileList.length);
		for(var i=0; i<fileList.length; i++){
		    if(fileList[i].checked == true){
		    	console.log(fileList[i].value);
		    	delList[i] = fileList[i].value;
		    }
		}
		for(var j=0;j<delList.length;j++){
	    	$('p').remove('.'+delList[j]);
		}

	}
	
</script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<div>
		<h1 style="text-align:center;">글쓰기</h1><br>
		<form id="summernote" method="post" action="${reviewSave }" enctype="multipart/form-data">
			<b>작성자</b><br>
			<input type="text" name="cust_id" value="${cust_id }" ><br>
			<b>제목</b><br>
			<input type="text" name="title" size="30" placeholder="제목을 입력해 주세요."><br>
			<b>내용</b><br>
			<textarea style="resize:none;" rows="40" cols="80" placeholder="내용을 입력해 주세요." name="content"></textarea><br>
			<b>파일명</b><br>
			<div id="fileList">

			</div>
			
			<div align="right" id="summernote">
				<input type="button" value="파일추가" onclick="add_file();">
				<input type="button" value="파일삭제" onclick="delete_file();">
				<input type="button" value="목록으로" onClick="location.href='${reviewHome}'"/>
				&emsp;
				<input type="submit" value="등록"/>
			</div> 
		</form>
	</div>
</body>
</html>