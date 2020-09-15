<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div align="center">
		<h1>비밀번호 확인</h1>
		<form action="boardCheckPass.do" name="frm" method="post">
		여기 숫자 있다~${num }
			<input type="hidden" name="num" value="${num }">
			<table style="width: 80%">
			 	<tr>
			 		<th>비밀번호</th>
			 		<td>
			 			<input type="password" name="pass" size="20">
			 		</td>
			 	</tr>
			</table>
			<br>
			<input type="submit" value="확인" onclick="return passCheck()">
			<br><br>${message }
		</form>
	</div>
</body>
</html>