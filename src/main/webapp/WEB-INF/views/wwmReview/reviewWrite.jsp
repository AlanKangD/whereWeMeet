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
</head>
<body>
	<div>
		<h1 style="text-align:center;">글쓰기</h1><br>
		<form method="post" action="${reviewSave }">
			<b>작성자</b><input type="text" name="cust_id" value="${cust_id }" ><br>
			<b>제목</b><input type="text" name="title" size="30" placeholder="제목을 입력해 주세요."><br>
			<b>내용</b><textarea style="resize:none;" rows="40" cols="80" placeholder="내용을 입력해 주세요." name="content"></textarea>
			<div align="right">
				<input type="button" value="목록으로" onClick="location.href='${reviewHome}'"/>
				&emsp;
				<input type="submit" value="등록"/>
			</div> 
		</form>
	</div>
</body>
</html>