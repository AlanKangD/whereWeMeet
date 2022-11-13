<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <c:set var="reviewHome" value="${contextPath }/wwmReview/reviewHome"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
	<div style="text-align: left;">
		<h1>${ reviewContent.title }</h1>
	</div>
	<div>
		<strong>작성자</strong> ${reviewContent.cust_id }
	</div>		
	<div>
		<strong>작성일</strong> ${reviewContent.inpt_date }
		<strong>조회수</strong> ${reviewContent.view_cnt }
	</div>
	<div>
		<table border="1">
			<tr>
				<td>${ reviewContent.content }</td>
			</tr>
		</table>
	</div>
	<div style="margin-bottom: 30px;">
		<input type="button" value="목록으로" onClick="location.href='${reviewHome}'"/>
	</div>
</body>
</html>