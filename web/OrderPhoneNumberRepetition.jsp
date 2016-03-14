<%--
  Created by IntelliJ IDEA.
  User: wk_51920
  Date: 2014/11/18
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机号码重复</title>
    <link href="OrderSucess.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="center">
    <header>该手机号码已预约过！</header>
    <form action="SubmitPhoneNumber.do" method="POST">
        <p>
            请输入其他手机号：
            <input type="text" name="InputPhoneNumber"/>
            <input type="hidden" name="DateAndDepartment" value="${submitDD}"/>
            <input type="hidden" name="OrderOrCancel" value="${OOC}"/>
            <input type="submit" value="提交手机号"/>
        </p>
    </form>
    <p id="backToIndex">
    <a  href="index.jsp">点此返回首页</a>
</p>
</div>
</body>
</html>