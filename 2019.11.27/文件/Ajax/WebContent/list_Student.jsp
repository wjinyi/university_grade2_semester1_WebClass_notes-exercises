<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-2.1.4.min.js"></script>	
<title>Insert title here</title>
</head>
<body>
<div>
            <p> 学生信息: <input type="text" name="stuInfo" id="stuInfo"></p>
            <p><button onclick="searchExam()">查询</button></p>
  </div>
  <table border="2" id="examTable">
        <tr id="examTr">
            <td>姓名</td>
            <td>日期</td>
            <td>Email</td>
        </tr>         
    </table>
    <script type="text/javascript">
        function searchExam(){        	
            //将表格内容全部清空
            $("#examTable").html("");
            //填充表格表头
            $("#examTable").append("<tr id='examTr'><td>姓名</td><td>日期</td><td>email</td></tr>");      
            
            //获取信息,传递到后台查询
            var stuInfo = $("#stuInfo").val();
            console.log(stuInfo);
            var data = {kkk: stuInfo, kkk2: "123"};
            console.log(data);
            
            $.post("./SearchInfoServlet", data, function(json) {            	
            	alert("json: " + json);            	
                //解析后台传递过来的json字符串
                $.each($.parseJSON(json),function(i,data){  
                    $("#examTr").after("<tr id='aaa'><td>"+data.sname+"</td><td>"+data.sdate+"</td><td>"+data.email+"</td></tr>");
                })
            })
        }
  </script>
</body>
</html>