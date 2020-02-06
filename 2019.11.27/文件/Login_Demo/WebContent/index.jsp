<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
form,h1{
text-align:center;
}
</style>

</head>
<body>
<h1 >用户登录</h1>
<form id="form1" action="LoginServlet" method="post">
用户名:<input type="text" name="username"><br/><br/>
密&nbsp;&nbsp;码:<input type="password" name="psd"><br/><br/>
<input type="submit" value="登录">
<input type="button" value="重置">
</form>

</body>
</html>