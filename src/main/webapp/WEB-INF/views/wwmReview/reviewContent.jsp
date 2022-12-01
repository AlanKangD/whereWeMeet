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
		<table border="1">
			<tr>
				<th>
					작성자
				</th>
				<td>
					${reviewContent.cust_id }
				</td>
			</tr>
			<tr>
				<th>
					작성일
				</th>
				<td>
					${reviewContent.inpt_date }
				</td>
				<th>
					조회수
				</th>
				<td>
					${reviewContent.view_cnt }
				</td>
			</tr>
			<tr>

			</tr>
			<tr>
				<td colspan ="4"> 
					${ reviewContent.content }
				</td>
			</tr>
		</table>
	</div>

	<div style="margin-bottom: 30px;">
		<input type="button" value="목록으로" onClick="location.href='${reviewHome}'"/>
	</div>
</body>
</html>