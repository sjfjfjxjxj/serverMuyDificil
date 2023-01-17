<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수신 결과</title>
</head>
<body>
	성별 : ${requestScope.gender}<br>
	정보 수신여부: ${requestScope.chkMail}<!-- requestScope.키값 -->
</body>
</html>