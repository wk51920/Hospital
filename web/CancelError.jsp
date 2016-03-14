<%--
  Created by IntelliJ IDEA.
  User: wk_51920
  Date: 2014/11/19
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机号码错误！</title>
    <link href="InputPhoneNumberError.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="center">
    <header>此号码尚未预约！</header>
    <form action="SubmitPhoneNumber.do" method="POST">
        请重新输入您的手机号：
        <input type="text" name="InputPhoneNumber" />
        <input type="hidden" name="DateAndDepartment" value="${submitDD}"/>
        <input type="hidden" name="OrderOrCancel" value="${OOC}"/>
        <input type="submit" value="提交手机号"/>
    </form>
    <p id="backToIndex">
        <a  href="index.jsp">点此返回首页</a>
    </p>
</div>
</body>
</html>