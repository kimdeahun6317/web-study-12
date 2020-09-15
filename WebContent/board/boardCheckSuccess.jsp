<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script type="text/javascript">
 	if(window.name == "update"){
 		alert("업데이트다");
 		window.opener.parent.location.href="boardUpdate.do?num=${param.num}";
 	}else if(window.name == 'delete'){
 		alert('삭제 버튼이다.');
 		window.opener.parent.location.href="boardDelete.do?num=${param.num}";
 	}
 	window.close();
 </script>
</body>
</html>