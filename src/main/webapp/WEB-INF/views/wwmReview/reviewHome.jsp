<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="reviewHome" value="${contextPath}/wwmReview/reviewHome"/>
    <c:set var="reviewContent" value="${contextPath}/wwmReview/reviewContent"/>
    <c:set var="reviewWrite" value="${contextPath}/wwmReview/reviewWrite"/>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div>
		<h1>
			게시판
		</h1>
	</div>
	<div>
		
		<table border = "1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:set var="reviewNo" value = "${dataCount}"/>
			
			
			<!-- 리뷰글 게시판에 나열 -->
			<c:forEach var="reviewList" items="${reviewList }"> 
				<tr>
					<td>${reviewNo }</td>
					<td>
						<a href = "${reviewContent }?content_id=${reviewList.content_id}">${reviewList.content_id} ${reviewList.title }</a>
					</td>
					<td>${reviewList.cust_id }</td>
					<td>${reviewList.inpt_date }</td>
					<td>${reviewList.view_cnt }</td>
				</tr>
				<c:set var="reviewNo" value = "${reviewNo -1 }"/>
			</c:forEach>
		</table>
	</div>
	<div>
		<!-- 페이징 -->
		<c:forEach var="cnt" begin="${beginPage}" end="${ endPage }">
			<c:choose>
				<c:when test="${num == cnt }">
					<a href="${reviewHome}?num=${cnt}"><b>${cnt}</b></a>
				</c:when>
				<c:otherwise>
					<a href="${reviewHome}?num=${cnt}">${cnt}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
	<div align="right">
		<input type="button" value="글쓰기" onclick="location.href='${reviewWrite}'">
	</div>
</body>
</html>