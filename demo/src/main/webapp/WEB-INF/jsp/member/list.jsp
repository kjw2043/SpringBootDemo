<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script type="text/javascript">
	function add(){
		location.href = "";
	}
</script>
</head>
<body>
	<h1>회원 목록</h1>
	<div>
		<button type="button" onclick="add();">등록</button>
	</div>
	<table border="1" style="width: 100%; border: 1px gray solid;">
		<colgroup>
			<col width="5%">
			<col width="30%">
			<col width="*">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="li" varStatus="vs">
				<tr>
					<td><c:out value="${vs.count}"/></td>
					<td><c:out value="${li.name}"></c:out></td>
					<td><c:out value="${li.email}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>